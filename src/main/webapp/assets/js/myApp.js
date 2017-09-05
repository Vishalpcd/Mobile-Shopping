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

	var products=[
					['1','vishal','pathak'],
					['1','vishal1','pathak1'],
					['1','vishal2','pathak2'],
					['1','vishal3','pathak3'],
					['1','vishal4','pathak4'],
					['1','vishal5','pathak5']
							
	];

	var $table= $('#productListTable');

	if($table.length)
		{
		$table.DataTable({
			data:products
		});
			
			//console.log('inside the table');
		}
	
	
});
