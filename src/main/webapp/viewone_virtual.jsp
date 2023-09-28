<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<script type="text/javascript" src="v1files/viewone.js"></script>	
</head>
<body>
	<object class="com.ibm.dv.client.Viewer" id="viewone" width="1600" height="800">
		<param name="annotate" value="true">
		<param name="annotateEdit" value="true">
		<param name="annotationSaveServlet" value="http://localhost:8080/ViewerAngularLPA/ViewerServlet">
		<param name="annotationFile" value="http://localhost:8080/ViewerAngularLPA/ViewerServlet">		
	</object>
	<script>
				if(sessionStorage.getItem("path") == null) {
					console.log("Estoy en el if")
					var pathInLocalStorage = localStorage.getItem("path");
					console.log("Path in localStorage: ", pathInLocalStorage);
					sessionStorage.setItem("path", pathInLocalStorage);
				}
				var root = document.getElementById("viewone");
				var path2 = sessionStorage.getItem('path');
				var newElement = document.createElement('param');
				newElement.name = "filename";
			    newElement.value = path2;
				root.appendChild(newElement);
		
	</script>
	
	
</body>
</html>

