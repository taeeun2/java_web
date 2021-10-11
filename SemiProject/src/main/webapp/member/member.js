function idCheck(){

	var url = "idCheck.html";
	window.open(url,"pop","width=500,height=500");
	
}

function searchPost(){
	var dong = formm.zip_num.value.trim();
	console.log(dong.length+'->'+dong);
	if(dong.length == null || dong == '')
		alert("~동을 입력해주세요");
	else{
		window.open('post.html','pop','width=600,height=500');
	}
}

function go_save(){
		var id = formm.id.value.trim();
		var pwd = formm.pwd.value.trim();
		var name = formm.name.value.trim();
		var email = formm.email.value.trim();
		var zip_num = formm.zip_num.value.trim();
	    var phone = formm.phone.value.trim();
	    

		if(id.length == 0 || id == '')
			alert("아이디는 필수입니다.");
		else if(email.length == 0 || email == '')
			alert("이메일은 필수입니다.");
		else if(pwd.length == 0 || pwd == '')
			alert("비밀번호는 필수입니다.");
		else if(name.length == 0 || name == '')
			alert("이름은 필수입니다.");
		else if(zip_num.length == 0 || zip_num == '')
			alert("우편번호는 필수입니다.");

		else if(phone.length == 0 || phone == '')
			alert("휴대폰번호는 필수입니다.");
		else{
			formm.method = "post";
			formm.action = "../join";
			formm.submit();
		}
}