<%@page import="java.util.HashMap"%>
<%@page import="com.whitestone.chisel.controller.WebController" %>
<%
	HashMap cim = new HashMap();
	cim.put("action","action-test");
	
	WebController controller = new WebController();
	HashMap com = controller.process(cim);
	
	System.out.println("cim: " + cim.toString());
	System.out.println("com: " + com.toString());
	
	String cimResult = (String)cim.get("result");
	
	String comResult = (String)com.get("result");
%>
<html>
<head>
</head>
<body>
	<h3>WAR jsp - EJB test</h3>
	<label for="cimResult">CIM Result:</label>
	<input type="text" id="cimResult" value="<%= cimResult %>" />
	<label for="comResult">COM Result:</label>
	<input type="text" id="comResult" value="<%= comResult %>" />
</body>
</html>