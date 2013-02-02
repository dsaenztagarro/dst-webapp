
/**
 * Axis2ServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1  Built on : Aug 31, 2011 (12:22:40 CEST)
 */
        package com.davlanca.webapp.ws.axis2;

        /**
        *  Axis2ServiceMessageReceiverInOut message receiver
        */

        public class Axis2ServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        Axis2ServiceSkeletonInterface skel = (Axis2ServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){


        

            if("createPeople".equals(methodName)){
                
                com.davlanca.webapp.ws.CreatePeopleResponse createPeopleResponse8 = null;
	                        com.davlanca.webapp.ws.CreatePeople wrappedParam =
                                                             (com.davlanca.webapp.ws.CreatePeople)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.davlanca.webapp.ws.CreatePeople.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               createPeopleResponse8 =
                                                   
                                                   
                                                           wrapCreatePeopleResponse_return(
                                                       
                                                        

                                                        
                                                       skel.createPeople(
                                                            
                                                                getArgs0(wrappedParam)
                                                            ,
                                                                getArgs1(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), createPeopleResponse8, false, new javax.xml.namespace.QName("http://ws.webapp.davlanca.com",
                                                    "createPeople"));
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        }
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
            private  org.apache.axiom.om.OMElement  toOM(com.davlanca.webapp.ws.CreatePeople param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.davlanca.webapp.ws.CreatePeople.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.davlanca.webapp.ws.CreatePeopleResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.davlanca.webapp.ws.CreatePeopleResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.davlanca.webapp.ws.CreatePeopleResponse param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.davlanca.webapp.ws.CreatePeopleResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getArgs0(
                        com.davlanca.webapp.ws.CreatePeople wrappedType){
                        
                                return wrappedType.getArgs0();
                            
                        }
                     

                        private java.lang.String getArgs1(
                        com.davlanca.webapp.ws.CreatePeople wrappedType){
                        
                                return wrappedType.getArgs1();
                            
                        }
                     

                        
                        private com.davlanca.webapp.ws.CreatePeopleResponse wrapCreatePeopleResponse_return(
                        com.davlanca.webapp.model.xsd.People param){
                        com.davlanca.webapp.ws.CreatePeopleResponse wrappedElement = new com.davlanca.webapp.ws.CreatePeopleResponse();
                        
                                wrappedElement.set_return(param);
                            
                            return wrappedElement;
                        }
                     
                         private com.davlanca.webapp.ws.CreatePeopleResponse wrapcreatePeople(){
                                com.davlanca.webapp.ws.CreatePeopleResponse wrappedElement = new com.davlanca.webapp.ws.CreatePeopleResponse();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.davlanca.webapp.ws.CreatePeople.class.equals(type)){
                
                           return com.davlanca.webapp.ws.CreatePeople.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.davlanca.webapp.ws.CreatePeopleResponse.class.equals(type)){
                
                           return com.davlanca.webapp.ws.CreatePeopleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    

        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    