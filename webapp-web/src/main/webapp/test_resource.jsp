<%@page import="java.io.InputStream"%>
<%@page import="java.util.ResourceBundle" %>
<% 
	ResourceBundle propertyBundle = ResourceBundle.getBundle("properties.chiselConfig");

	ResourceBundle settingsBundle = ResourceBundle.getBundle("com.whitestone.configuration.chiselSettings.properties");
	
	InputStream is = getClass().getResourceAsStream( "com.whitestone.configuration.chiselSettings.properties" );
	System.out.println("InputStream: " + is);

	String INITIAL_CONTEXT_FACTORY = propertyBundle.getString("chisel.initial.context.factory.class.jboss");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>WAR jsp - ResourceBundle test</h3>
	<label for="cimResult">INITIAL_CONTEXT_FACTORY (WAR):</label>
	<input type="text" id="cimResult" value="<%= INITIAL_CONTEXT_FACTORY %>" />
	<label for="cimResult">INITIAL_CONTEXT_FACTORY (external):</label>
	<input type="text" id="cimResult" value="<%= INITIAL_CONTEXT_FACTORY %>" />
</body>
</html>