package com.davlanca.webapp.ejb.publisher.topic;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface TopicPublisherBeanLocal extends EJBHome {
	public TopicPublisherBean create() throws CreateException, RemoteException;
}
