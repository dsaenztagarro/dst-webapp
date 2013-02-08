package com.davlanca.webapp.ejb.test;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;

/**
 * Session Bean implementation class TestBean
 */

public class TestBean implements javax.ejb.SessionBean {

    /**
     * Default constructor. 
     */
    public TestBean() {
        //Auto-generated constructor stub
    }

	@Override
	public void ejbActivate() throws EJBException, RemoteException {
		//Auto-generated method stub
		
	}

	@Override
	public void ejbPassivate() throws EJBException, RemoteException {
		//Auto-generated method stub
		
	}

	@Override
	public void ejbRemove() throws EJBException, RemoteException {
		//Auto-generated method stub
		
	}

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException,
			RemoteException {
		//Auto-generated method stub
		
	}
	
	public HashMap processRequest(HashMap cim) throws RemoteException {
		String action = (String)cim.get("action");
		System.out.println("processRequest >> " + action);
		HashMap com = new HashMap();
		com.put("result", action + "-processed");
		return com;
	}

}
