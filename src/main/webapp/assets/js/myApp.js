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
	case "allProducts":
		$("#allProducts").addClass("active");
		break;
		default:
			$("#brand").addClass("active");
		break;
		
	}
	/*
	
	function test(id){
		alert('SAMEER ' +id);
	};
	*/

	
	var $table= $('#productListTable');

	if($table.length)
		{
		var jsonUrl='';
		if(window.categoryId=='')
			{
			 jsonUrl='/MobileShopping/json/data/all/products';
			}
		else if(window.categoryId==''+window.categoryId+'')
			{
	       // alert('${category.id}');
	       // alert(window.categoryId);
			//jsonUrl='/MobileShopping/json/data/type/'+window.typeId+'/products';
			jsonUrl='/MobileShopping/json/data/type/'+window.categoryId+'/products';
			}
		else if(window.typeId==''+window.typeId+'')
			{
			jsonUrl='/MobileShopping/json/data/type/'+window.typeId+'/products';
			}
		else 
			{
			jsonUrl='/MobileShopping/json/data/type/'+window.brandId+'/products';
			/*jsonUrl='/MobileShopping/json/data/brand/'+window.brandId+'/products';*/
			}
		/*else
			{
			alert(''+window.brandId+'')
			jsonUrl='/MobileShopping/json/data/brand/'+window.brandId+'/products';
			}*/
		
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 records','5 records','10 records','all']],
			pageLength: 3,
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},
			columns:[
				
				{
					data: 'code',
					bSortable: false,
					mRender: function(data,type,row)
					{
						return '<img src="/MobileShopping/resources/images/'+data+'.jpg" id="Listimage" class="img-responsive img-circle"/>'
					}
				},
				{
					data: 'name'
				},
				{
					data: 'brand'
				},

				{
					data: 'unitPrice',
					mRender: function(data,type,row)
					{
						return '&#x20B9; ' +data//getting the rupee symbol 
					}
				},

				{
					data: 'quantity'
				},
				{
					data: 'id',
					bSortable: false,
					mRender: function(data,type,row)
					{
						var str='';
						str+='<a href="/MobileShopping/show/'+data+'/product" class="btn btn-info"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';//for creating extra space 
						str+='<a href="/MobileShopping/cart/add/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						
						return str;
					}
				}
				
			]
			
			
			
			
			
			
		});
			
			//console.log('inside the table');
		}



	
	
});

