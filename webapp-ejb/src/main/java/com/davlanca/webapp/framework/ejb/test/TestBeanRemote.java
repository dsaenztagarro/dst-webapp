package com.davlanca.webapp.framework.ejb.test;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBObject;

public interface TestBeanRemote extends EJBObject {
	public HashMap processRequest(HashMap params) throws RemoteException;
}
