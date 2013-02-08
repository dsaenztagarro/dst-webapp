package com.davlanca.webapp.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davlanca.webapp.util.JMSProvider;

/**
 * Servlet implementation class ActionBackendServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MessageServlet() {
        //Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		String message = request.getParameter("message");
		
		if (action!=null) {
			if (action.equals("sendQueueMessage")) {
				JMSProvider ruleLauncher = new JMSProvider();
				ruleLauncher.sendQueueMessage(message);
			}
			else if (action.equals("sendTopicMessage")) {
				JMSProvider ruleLauncher = new JMSProvider();
				ruleLauncher.sendTopicMessage(message);
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
