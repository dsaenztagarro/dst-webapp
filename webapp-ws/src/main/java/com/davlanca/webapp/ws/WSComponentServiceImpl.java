package com.davlanca.webapp.ws;

import com.davlanca.webapp.model.xsd.People;
import com.davlanca.webapp.ws.Axis2ServiceSkeleton;

public class WSComponentServiceImpl extends Axis2ServiceSkeleton {

	@Override
	public People createPeople(String firstName, String lastName) {
		People people = new People();
		people.setPeopleID(123);
		people.setFirstName(firstName+"-Updated Again");
		people.setLastName(lastName+"-Updated Again");
		return people;
	} 
}
