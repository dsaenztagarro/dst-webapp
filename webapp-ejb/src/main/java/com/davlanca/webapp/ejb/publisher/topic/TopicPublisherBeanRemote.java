package com.davlanca.webapp.ejb.publisher.topic;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBObject;

public interface TopicPublisherBeanRemote extends EJBObject {
	public HashMap processRequest(HashMap params) throws RemoteException;
}
