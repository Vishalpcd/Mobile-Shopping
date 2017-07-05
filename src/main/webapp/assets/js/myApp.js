$(function() {
	switch(menu)
	{
	//it will set active class to the about link 
	case "home":
		$("#home").addClass("active");//using bootstrap active class 
		break;
	case "about":
		$("#about").addClass("active");
		break;
	case "login":
		$("#login").addClass("active");
		break;
	case "signup":
		$("#signup").addClass("active");
		break;
		default:
			$("#brand").addClass("active");
		break;
		
	}
})