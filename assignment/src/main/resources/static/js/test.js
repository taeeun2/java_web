function login1(){
	
	var id = $("#id").val();
	var pw = $("#pw").val();
	
	alert(id+":"+pw);
}

function login2(){
	var _id = $("#id").val();
	var _pw = $("#pw").val();
	
	$.ajax({
		type:"post",
		dataType : "text",
		async : false,
		url : "/login",
		data : {id:_id,pw:_pw},
		success:function(data){
			var user = JSON.parse(data);
			alert("Data:"+user.userName+"님 login ok\nStatus: sucess");
		
		},
		
	});
	
}
