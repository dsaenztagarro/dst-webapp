package com.davlanca.webapp.test.ws.people;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.davlanca.webapp.model.xsd.People;
import com.davlanca.webapp.test.ws.WSComponentServiceStub;

public class WSCreatePeopleTest extends junit.framework.TestCase{

	private String firstName = null;
	private String lastName = null;
	
	@Override
	public void setUp() {
		firstName = "Simon";
		lastName = "Rodriguez";
	}
	
    public void testCreatePeople() throws java.lang.Exception{
    	WSComponentServiceStub wsComponentserviceStub = new WSComponentServiceStub();
    	People people = wsComponentserviceStub.getInstance().createPeople(firstName, lastName);
    	if (people != null) {
	    	System.out.println("Test.createPeople.firstName: " + people.getFirstName());
	    	System.out.println("Test.createPeople.lastName: " + people.getLastName());
	    	boolean result = people.getFirstName().equals("Simon-Updated2") &&
	    			people.getLastName().equals("Rodriguez-Updated") &&
	    			people.getPeopleID() == 123;
	    	this.assertFalse("People wasn't created with expected values", result);
    	} else {
    		fail("People couldn't be created");
    	}
    }

}
    