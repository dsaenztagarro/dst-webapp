package com.davlanca.webapp.ejb.publisher.queue;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBObject;

public interface QueuePublisherBeanRemote extends EJBObject {
	public HashMap processRequest(HashMap params) throws RemoteException;
}
