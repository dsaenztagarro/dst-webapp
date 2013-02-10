package com.davlanca.webapp.test.ws.people;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.davlanca.webapp.model.xsd.People;

public class WSUpdatePeopleTest extends junit.framework.TestCase{

	private String firstName = null;
	private String lastName = null;
	
	@Override
	public void setUp() {
		firstName = "Simon";
		lastName = "Rodriguez";
	}
	
    public void testCreatePeople() throws java.lang.Exception{
    	fail("People couldn't be updated");
    }

}
    