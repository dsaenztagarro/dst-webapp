package com.davlanca.webapp.ejb.publisher.queue;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface QueuePublisherBeanLocal extends EJBHome {
	public QueuePublisherBean create() throws CreateException, RemoteException;
}
