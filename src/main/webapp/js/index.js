
var testing = function(value) {
    if (localStorage) {
		console.log("LocalStorage is supported!");
		// Save the name in localStorage.
      	localStorage.setItem('name', "name value");
	} else {
		console.log("No support!");
	}
    
};