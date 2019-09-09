
function display(){
	if($(".test").eq(1).css("display") == "block"){
		$("#table").css("margin-top","70px");
	}else if($(".test").eq(2).css("display") == "block"){
		$("#table").css("margin-top","70px");
	}else if($(".test").eq(3).css("display") == "block"){
		$("#table").css("margin-top","70px");
	}else if($(".test").eq(4).css("display") == "block"){
		$("#table").css("margin-top","70px");
	}else if($(".test").eq(0).css("display") == "block"){
		$("#table").css("margin-top","70px");
	}else if($(".test").eq(5).css("display") == "block"){
		$("#table").css("margin-top","40px");
	}else{
		$("#table").css("margin-top","0px");
	}
}

function hide(){
	
	$("#goods").hide();
	$("#order").hide();
	$("#type").hide();
	$("#notice").hide();
	$("#user").hide();
	$("#out").hide();
}

$(function(){
	setInterval("display()",1);
	$("#navigator li:first").css("margin-left","0px");
	hide();

	$(".test li:eq(0)").eq(0).click(function(){
		hide();
		$("#goods").show();
	});

	$(".test li:eq(1)").eq(0).click(function(){
		hide();
		$("#goods").show();
	});

	$(".test li:eq(2)").eq(0).click(function(){
		hide();
		
		$("#goods").show();
	});

	$(".test li:eq(3)").eq(0).click(function(){
		hide();
		$("#goods").show();
	});





	$(".test:eq(1) li:eq(0)").click(function(){
		
		hide();
		$("#type").show();
	});

	$(".test:eq(1) li:eq(1)").click(function(){
		
		hide();
		$("#type").show();
	});

	$(".test:eq(1) li:eq(2)").click(function(){
		
		hide();
		$("#type").show();
	});

	$(".test:eq(1) li:eq(3)").click(function(){
		
		hide();
		$("#type").show();
	});


	$(".test:eq(2) li:eq(0)").click(function(){
		
		hide();
		$("#user").show();
	});

	$(".test:eq(2) li:eq(1)").click(function(){
		
		hide();
		$("#user").show();
	});

	$(".test:eq(2) li:eq(2)").click(function(){
		
		hide();
		$("#user").show();
	});

	$(".test:eq(2) li:eq(3)").click(function(){
		
		hide();
		$("#user").show();
	});



	$(".test:eq(3) li:eq(0)").click(function(){
		
		hide();
		$("#order").show();
	});

	$(".test:eq(3) li:eq(1)").click(function(){
		
		hide();
		$("#order").show();
	});

	$(".test:eq(3) li:eq(2)").click(function(){
		
		hide();
		$("#order").show();
	});

	$(".test:eq(3) li:eq(3)").click(function(){
		
		hide();
		$("#order").show();
	});




	$(".test:eq(4) li:eq(0)").click(function(){
		hide();
		$("#notice").show();
	});

	$(".test:eq(4) li:eq(1)").click(function(){
		
		hide();
		$("#notice").show();
	});

	$(".test:eq(4) li:eq(2)").click(function(){
		
		hide();
		$("#notice").show();
	});

	$(".test:eq(4) li:eq(3)").click(function(){
		
		hide();
		$("#notice").show();
	});
			
			
			
			
			
	$(".test:eq(5) li:eq(0)").click(function(){
		
		hide();
		$("#out").show();
	});
	
	$(".test:eq(5) li:eq(1)").click(function(){
		
		hide();
		
	});
	
	
	
	
	
	
});


		
		