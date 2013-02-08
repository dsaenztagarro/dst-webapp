package com.davlanca.webapp.ejb.jms;

import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class QueueMessageDrivenBean implements MessageDrivenBean, MessageListener {

    private transient MessageDrivenContext mdbContext;

    public QueueMessageDrivenBean() {}

    public void setMessageDrivenContext(MessageDrivenContext ctx) {
        mdbContext = ctx;
    }

    public void ejbRemove() {}

    public void ejbCreate() {}

    public void onMessage(Message message) {
        try {
            TextMessage mess = (TextMessage)message;
            System.out.println( "QueueMessageDrivenBean: Message Received: "+mess.getText());
        }catch(JMSException ex){
            System.err.println("Exception caught: "+ex);
        }
    }
}
