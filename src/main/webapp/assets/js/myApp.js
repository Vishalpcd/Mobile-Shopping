 function PassWordMatch()
{
	var password1=document.getElementById("ps1");
	var password2=document.getElementById("ps2");
	if(password1.value!=password2.value)
		{
			alert("password do not match !!!");
			return false;
			
		}
	else
		{
			return true;
		}
}

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
//to tackle the  csrf token
	var token=$('meta[name="_csrf"]').attr('content');
	var header=$('meta[name="_csrf_header"]').attr('content');
	if(token.length > 0 && header.length >0)
		{
			$(document).ajaxSend(function(e,xhr,options)
					{
						xhr.setRequestHeader(header,token);
					});
			
		}
	
	var $table= $('#productListTable');

	if($table.length)
		{
		var jsonUrl='';
		if(window.categoryId=='')
			{
			 jsonUrl='/MobileShopping/json/data/all/products';
			}
		else if(window.categoryId==''+window.categoryId)
			{
	       // alert('${category.id}');
	       // alert(window.categoryId);
			//jsonUrl='/MobileShopping/json/data/type/'+window.typeId+'/products';
			jsonUrl='/MobileShopping/json/data/category/'+window.categoryId+'/products';
			}
		else if(window.typeId==''+window.typeId)
			{
			jsonUrl='/MobileShopping/json/data/type/'+window.typeId+'/products';
			}
		else 
			{
			/*alert(''+window.brandId);*/
			jsonUrl='/MobileShopping/json/data/brand/'+window.brandId+'/products';
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
						//if the user is user then only available to the user 
						if(userRole=='USER')
							{
								str+='<a href="/MobileShopping/cart/add/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
							}
						return str;
					}
				}
				
			]
			
			
			
			
			
			
		});
			
			//console.log('inside the table');
		}
	
	$('.switch input[type="checkbox"]')
	.on(
			'change',
			function() {

				// alert('entering function');
				var checkbox = $(this);
				// check if the checkbox is checked returns true or
				// false
				var checked = checkbox.prop('checked');
				var dMsg = (checked) ? 'You want to activate the product?'
						: 'You want to deactivate the product?';
				var value = checkbox.prop('value');

				bootbox
						.confirm({
							size : 'medium',
							title : 'Product Activation & Deactivation',
							message : dMsg,

							callback : function(confirmed) {
								if (confirmed) {

									bootbox
											.alert({
												size : 'medium',
												title : 'Information',
												message : 'You are going to perform operation on product'
														+ value
											});

								} else {
									checkbox.prop('checked', !checked);
								}
							}
						});

});
	
	var $eTable=$('#editTableProduct')
	if($eTable.length)
		{
		var jsonUrl='/MobileShopping/json/data/admin/all/products';
		$eTable.DataTable({
			lengthMenu:[[3,5,10,-1],['3 records','5 records','10 records','all']],
			pageLength: 3,
			ajax:{
				url:jsonUrl,
				dataSrc:''
			},

			columns:[
				{
					data: 'id'
				},
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
					data:'active',
						bSortable:false,
						mRender:function(data,type,row)
						{
							
							var str='';
							str+='<label class="switch">'
								if(data)
									{
									str+='<input type="checkbox" checked="checked" value="'+row.id+'">'
									}
								else
									{
									str+='<input type="checkbox" value="'+row.id+'" >'
									}
									str+='<span class="slider"></span></label>';
							return str;
						}
				}
				
		],
			

		initComplete : function() {

			var api = this.api();

			api
					.$('.switch input[type="checkbox"]')
					.on(
							'change',
							function() {

								// alert('entering function');
								var checkbox = $(this);
								// check if the checkbox is
								// checked
								// returns true or
								// false
								var checked = checkbox
										.prop('checked');
								var dMsg = (checked) ? 'You want to activate the product?'
										: 'You want to deactivate the product?';
								var value = checkbox.prop('value');

								bootbox
										.confirm({
											size : 'medium',
											title : 'Product Activation & Deactivation',
											message : dMsg,

											callback : function(
													confirmed) {

												if (confirmed) {

													var activationUrl = '/MobileShopping/Manage/product/'+ value+ '/activation';
													$
															.post(
																	activationUrl,
																	function(
																			data) {
																		bootbox
																				.alert({
																					size : 'medium',
																					title : 'Info',
																					message : data
																				});
																	});

												} else {
													checkbox
															.prop(
																	'checked',
																	!checked);
												}
											}
										});

							});
		}

	});

}






		
	
});






