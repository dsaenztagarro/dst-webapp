package com.davlanca.webapp.ejb.jms;

import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

public class TopicMessageDrivenBean implements MessageDrivenBean, MessageListener {

    private transient MessageDrivenContext mdbContext;

    public TopicMessageDrivenBean() {}

    public void setMessageDrivenContext(MessageDrivenContext ctx) {
        mdbContext = ctx;
    }

    public void ejbRemove() {}

    public void ejbCreate() {}

    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
            	ObjectMessage om = (ObjectMessage)message;
            	System.out.println( "TopicMessageDrivenBean: ObjectMessage Received: "+ om);
            	System.out.println( "TopicMessageDrivenBean: ObjectMessage Received: "+ om.getObject());
            }
        }catch(JMSException ex){
            System.err.println("Exception caught: "+ex);
        }
    }
}
