package com.davlanca.webapp.test.ws;

import org.apache.axis2.AxisFault;

import com.davlanca.webapp.test.ws.client.Axis2ServiceStub;

public class WSComponentServiceStub {

	private Axis2ServiceStub service = null;
	
	public Axis2ServiceStub getInstance() {
		try {
			if (service == null) {
				service = new Axis2ServiceStub("http://localhost:8080/webapp-web/services/WSComponentService");
			}
		} catch (AxisFault e) {
			System.out.println(e.getFaultAction());
		}
		return service;
	}
}
