

/**
 * Axis2ServiceAxis2ServiceHttpSoap12EndpointTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
    package com.davlanca.webapp.ws;

    /*
     *  Axis2ServiceAxis2ServiceHttpSoap12EndpointTest Junit test case
    */

    public class Axis2ServiceAxis2ServiceHttpSoap12EndpointTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testcreatePeople() throws java.lang.Exception{

        com.davlanca.webapp.ws.Axis2ServiceAxis2ServiceHttpSoap12EndpointStub stub =
                    new com.davlanca.webapp.ws.Axis2ServiceAxis2ServiceHttpSoap12EndpointStub();//the default implementation should point to the right endpoint

           com.davlanca.webapp.ws.CreatePeople createPeople80=
                                                        (com.davlanca.webapp.ws.CreatePeople)getTestObject(com.davlanca.webapp.ws.CreatePeople.class);
                    // TODO : Fill in the createPeople80 here
                
                        assertNotNull(stub.createPeople(
                        getArgs0(createPeople80)
                                      ,getArgs1(createPeople80)
                                      ));
                  



        }
        
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

                            private java.lang.String getArgs0(
                            com.davlanca.webapp.ws.CreatePeople wrappedType){
                            
                                    return wrappedType.getArgs0();
                                
                            }

                         

                            private java.lang.String getArgs1(
                            com.davlanca.webapp.ws.CreatePeople wrappedType){
                            
                                    return wrappedType.getArgs1();
                                
                            }

                         

    }
    