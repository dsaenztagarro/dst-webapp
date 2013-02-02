package com.davlanca.webapp.controller;

import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.davlanca.webapp.framework.ejb.test.TestBeanRemote;

public class WebController {
	
	public HashMap process(HashMap params) {
		
		HashMap com = null;
		try {
			ResourceBundle propertyBundle = ResourceBundle.getBundle("chiselConfig");
			//String INITIAL_CONTEXT_FACTORY = propertyBundle.getString("chisel.initial.context.factory.class.jboss");
			String INITIAL_CONTEXT_FACTORY = "org.jboss.as.naming.InitialContextFactory";
			
			System.out.println("INITIAL_CONTEXT_FACTORY >> " + INITIAL_CONTEXT_FACTORY);
			
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			prop.put(Context.PROVIDER_URL, "localhost:1099");
			prop.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			
			InitialContext jndiContext =  new InitialContext(prop);
			System.out.println(">>Obtenido un contexto JNDI <<");
			
			String jndiRef = "java:app/eartest-ejb-0.0.1-SNAPSHOT/TestBean!com.whitestone.chisel.framework.ejb.test.TestBeanRemote";
			Object ref = jndiContext.lookup(jndiRef);
			System.out.println(">> Obtenida referencia al bean \"TestBean\"");
			
			TestBeanRemote home = (TestBeanRemote)PortableRemoteObject.narrow(ref, TestBeanRemote.class);
			
			System.out.println(">> Invocando el EJB: " + home + " params: " + params);
			com = home.processRequest(params);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return com;
	}
}
