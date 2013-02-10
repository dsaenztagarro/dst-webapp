package com.davlanca.webapp.test.ws.people;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses({WSCreatePeopleTest.class,WSUpdatePeopleTest.class})
public class WSPeopleTestSuite {
    @BeforeClass public static void setUpClass() {
        // Common initialization done once for Test1 + Test2
    }
    
    @AfterClass public static void tearDownClass() {
        // Common cleanup for all tests
    }
}