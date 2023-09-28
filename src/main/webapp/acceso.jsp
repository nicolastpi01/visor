<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="ar.com.lpa.configuration.LPAServiceConfigurator"%>
<%
	LPAServiceConfigurator props = new LPAServiceConfigurator();
	props.readProperties();
	String path = props.getImage();
	System.out.println("Path in acceso.jsp: " + path);
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="js/saveInLocalStorage.js"></script>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body style="background:#84B0DC">  
	<script type="text/javascript" language="javascript">
		loadStorage('<%=path%>');
	</script>
</body>
</html>