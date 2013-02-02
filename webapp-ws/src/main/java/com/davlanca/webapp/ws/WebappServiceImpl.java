package com.davlanca.webapp.ws;

import com.davlanca.webapp.model.xsd.People;
import com.davlanca.webapp.ws.axis2.Axis2ServiceSkeleton;

public class WebappServiceImpl extends Axis2ServiceSkeleton {

	public People createPeople(String firstName, String lastName) {
		People people = new People();
		people.setPeopleID(123);
		people.setFirstName(firstName+"Updated");
		people.setLastName(lastName+"Updated");
		return people;
	} 
}
