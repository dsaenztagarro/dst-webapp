package com.davlanca.webapp.ejb.publisher.topic;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class TestBean
 */

public class TopicPublisherBean implements javax.ejb.SessionBean {

    /**
     * Default constructor. 
     */
    public TopicPublisherBean() {
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
		String message = (String)cim.get("message");

		if (action!=null && action.equals("sendTopicMessage") && message!=null) {
			InitialContext initialContext = null;
			TopicSession topicSession = null;
			TopicPublisher topicPublisher = null;
			try {
				initialContext = new InitialContext();
				TopicConnectionFactory factory =
				(TopicConnectionFactory)initialContext.lookup("RemoteConnectionFactory");
				Topic topic = (Topic)initialContext.lookup("java:/topic/test");

				//TopicConnection topicConnection = factory.createTopicConnection("jmsuser","jmsuser123");
				TopicConnection topicConnection = factory.createTopicConnection();
				topicSession = topicConnection.createTopicSession(false,topicSession.AUTO_ACKNOWLEDGE);
				
				topicPublisher = topicSession.createPublisher(topic);
				ObjectMessage objectMessage = topicSession.createObjectMessage();
				objectMessage.setObject(cim);
				
				topicPublisher.publish(objectMessage);
				topicConnection.close();
			} catch (NamingException e){
				e.printStackTrace();
	        } catch (JMSException e) {
				e.printStackTrace();
			} finally {
	            try {
	            	if (topicPublisher!=null) topicPublisher.close();	//LQD-080421-03
	            	if (topicSession != null) topicSession.close();	
	            } catch (JMSException e) {
	                e.printStackTrace();
	            }
	            
	        }
		}
		
		HashMap com = new HashMap();
		com.put("result", action + "-processed");
		return com;
	}

}
