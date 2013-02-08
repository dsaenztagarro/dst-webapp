package com.davlanca.webapp.ejb.test;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface TestBeanLocal extends EJBHome {
	public TestBean create() throws CreateException, RemoteException;
}
