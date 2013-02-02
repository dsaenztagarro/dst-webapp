package com.davlanca.webapp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.davlanca.webapp.controller.WebController;

/**
 * Servlet implementation class ActionBackendServlet
 */
public class ActionBackendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ActionBackendServlet() {
        //Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action!=null) {
			HashMap<String, Object> cim = new HashMap<String,Object>();
			cim.put("action", action);
			
			HashMap<String,Object> com = null;
			
			WebController webController = new WebController();
			com = webController.process(cim);

			String result = (String)com.get("result");
			
			PrintWriter out = null;
			response.setContentType("text/xml;charset=UTF-8");
			try {
				out = response.getWriter();
				if (out != null) {
					out.print(result);
				}
			} catch (IOException e) {
				e.printStackTrace();
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
