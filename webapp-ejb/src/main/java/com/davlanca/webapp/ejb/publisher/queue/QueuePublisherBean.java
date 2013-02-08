package com.davlanca.webapp.ejb.publisher.queue;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Session Bean implementation class TestBean
 */

public class QueuePublisherBean implements javax.ejb.SessionBean {

    /**
     * Default constructor. 
     */
    public QueuePublisherBean() {
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

		if (action!=null && action.equals("sendQueueMessage") && message!=null) {
			InitialContext contextoInicial = null;
			QueueSession sesion = null;
			try {
				// Conseguimos de la JNDI los objetos administrados
				contextoInicial = new InitialContext();
				QueueConnectionFactory factory =
				(QueueConnectionFactory)contextoInicial.lookup("RemoteConnectionFactory");
				Queue cola = (Queue)contextoInicial.lookup("java:/queue/test");
				// Creamos la conexion y la sesion
				//QueueConnection conexion = factory.createQueueConnection("jmsuser","jmsuser123");
				QueueConnection conexion = factory.createQueueConnection();
				sesion = conexion.createQueueSession(false,sesion.AUTO_ACKNOWLEDGE);
				// Creamos una sesion de envio
				QueueSender enviaACola = sesion.createSender(cola);
				// Creamos un mensaje
				TextMessage mensaje = sesion.createTextMessage();
				mensaje.setText(message);
				// Lo enviamos
				enviaACola.send(mensaje);
				System.out.println("QueuePublisherBean: Mensaje enviado: " + mensaje.getText());
				// Cerramos la conexion
				conexion.close();
			} catch (NamingException e){
				e.printStackTrace();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
		HashMap com = new HashMap();
		com.put("result", action + "-processed");
		return com;
	}

}
