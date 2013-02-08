package com.davlanca.webapp.util;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

import com.davlanca.webapp.ejb.publisher.queue.QueuePublisherBeanRemote;
import com.davlanca.webapp.ejb.publisher.topic.TopicPublisherBeanRemote;

public class JMSProvider {

	private QueuePublisherBeanRemote queuePublisher = null;
	private TopicPublisherBeanRemote topicPublisher = null;
	
	public JMSProvider() {
		HashMap com = null;
		try {
			//Initialize context
			
			//ResourceBundle propertyBundle = ResourceBundle.getBundle("chiselConfig");
			//String INITIAL_CONTEXT_FACTORY = propertyBundle.getString("chisel.initial.context.factory.class.jboss");
			String INITIAL_CONTEXT_FACTORY = "org.jboss.as.naming.InitialContextFactory";
			
			System.out.println("INITIAL_CONTEXT_FACTORY >> " + INITIAL_CONTEXT_FACTORY);
			
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.as.naming.InitialContextFactory");
			prop.put(Context.PROVIDER_URL, "localhost:1099");
			prop.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			
			InitialContext jndiContext =  new InitialContext(prop);
			System.out.println(">>Obtenido un contexto JNDI");
			
			//Init reference to QueuePublisherBean
			String jndiRef = "java:app/webapp-ejb-0.0.1-SNAPSHOT/QueuePublisherBean!com.davlanca.webapp.ejb.publisher.queue.QueuePublisherBeanRemote";
			Object queuePublisherBean = jndiContext.lookup(jndiRef);
			System.out.println(">> Obtenida referencia al bean \"queuePublisherBean\"");
			
			queuePublisher = (QueuePublisherBeanRemote)PortableRemoteObject.narrow(queuePublisherBean, QueuePublisherBeanRemote.class);

			//Init reference to TopicPublisherBean
			jndiRef = "java:app/webapp-ejb-0.0.1-SNAPSHOT/TopicPublisherBean!com.davlanca.webapp.ejb.publisher.topic.TopicPublisherBeanRemote";
			Object topicPublisherBean = jndiContext.lookup(jndiRef);
			System.out.println(">> Obtenida referencia al bean \"queuePublisherBean\"");
			
			topicPublisher = (TopicPublisherBeanRemote)PortableRemoteObject.narrow(topicPublisherBean, TopicPublisherBeanRemote.class);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void sendQueueMessage(String message) {
		try {
			if (queuePublisher!=null) {
				HashMap cim = new HashMap();
				cim.put("action","sendQueueMessage");
				cim.put("message", message);
				System.out.println(">> RuleLauncher: sendQueueMessage: " + queuePublisher + " message: " + message);
				HashMap com = queuePublisher.processRequest(cim);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendTopicMessage(String message) {
		try {
			if (topicPublisher!=null) {
				HashMap cim = new HashMap();
				cim.put("action","sendTopicMessage");
				cim.put("message", message);
				System.out.println(">> RuleLauncher: sendTopicMessage: " + topicPublisher + " message: " + message);
				HashMap com = topicPublisher.processRequest(cim);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
