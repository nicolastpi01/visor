var loadStorage = function(path) {
    if (localStorage) {
		console.log("sessionStorage is supported")
		// Save the name in localStorage.
		console.log("Path in js File: ", path)
      	//sessionStorage.setItem('path', path);
      	localStorage.setItem('path', path)
      	window.location.href = 'viewone_virtual.jsp'
	}
	/* 
	else {
		console.log("No support!");
	}
	*/
};

/*
var path2 = function(path) {
	return '<object class="com.ibm.dv.client.Viewer" id="viewone" width="1600" height="800">'+'<param name="annotate" value="true">'+'<param name="annotateEdit" value="true">'+'<param name="eventHandler" value="myEventHandler"/>'+'<param name="filename" value='+path+'>'+'<param name="annotationSaveServlet" value="http://localhost:8080/ViewerAngularLPA/ViewerServlet">'+'<param name="annotationFile" value="http://localhost:8080/ViewerAngularLPA/ViewerServlet">'+'</object>'
	/*
	if(sessionStorage.getItem("path") == null) {
			console.log("Estoy en el if")
			var pathInLocalStorage = localStorage.getItem("path");
			console.log("Path in localStorage: ", pathInLocalStorage);
			sessionStorage.setItem("path", pathInLocalStorage);
		} 
		var path = sessionStorage.getItem('path');
		//var param = document.createElement('param');
		//param.name = "filename";
		console.log("Path2 en SesionStorage: ", path);
	    //param.value = path;
	    //return param;
		//document.getElementById("viewone").appendChild(param)
		return '<param name="filename" value=' + path + '>'
		//return '<li>' + text + '</li>';
		*/


