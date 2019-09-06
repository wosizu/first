$(function(){
	var a =0;
	if(a==0){
		alert("来了");
		$.post("/HelloWeb/index",{},function(result){
			var html = '<tr><td>'+id+'</td> <td>'+name+'</td><td>'+age+'</td><td>'+groupid+'</td></tr>'
			$("#data").append(html);
			$('#'+id+' button[value="add"]').css("backgroundColor", "pink");
		})
		a++;
	}
	
});