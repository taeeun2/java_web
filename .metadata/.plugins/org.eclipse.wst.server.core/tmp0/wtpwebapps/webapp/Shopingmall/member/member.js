/**
 * 
 */


function alert_button(str) {
    alert(str);
}
function idCheck(){
	/*if(document.formm.id.value==""){
		alert('아이디를 입력하여 주십시오.');
		document.formm.id.focus();
	}else{*/
	
	var url = "../idCheck/idCheck.html";
		window.open(url,"pop","width=500,height=500");
		/*var url = "../../lecture/book/Ajax/ajax3.html";
		window.open(url,"pop","width=500,height=500");*/
		
/*		var url = "NonageServlet?command = id_check_form&id="
						+document.form.id.value;
		window.open(url,"_blank_1",
		"toolbar=no, menubar=no,scrollbars=yes, resizable=no,width=400,height=200");*/
	
}

function post_zip(){
	
}

function go_save(){
		var id = formm.id.value.trim();
		var pwd = formm.pwd.value.trim();
		var name = formm.name.value.trim();
		var email = formm.email.value.trim();
		var post = formm.post.value.trim();

		if(id.length == 0 || id == '')
			alert("아이디는 필수입니다.");
		else if(pwd.length == 0 || pwd == '')
			alert("비밀번호는 필수입니다.");
		else if(name.length == 0 || name == '')
			alert("이름은 필수입니다.");
		else if(email.length == 0 || email == '')
			alert("이메일은 필수입니다.");
		else if(post.length == 0 || post == '')
			alert("우편번호는 필수입니다.");
		else{
			formm.method = "post";
			formm.action = "../../NonageServlet?command=join";
			formm.submit();
		}
}
/*function searchPost(){
	var post = formm.post.value;
	window.open('/lecture/jspEx/Post.jsp', 'pop', 'width=500,height=500');//세번째 인자값 하나로 묶을 것
	
}
	*/
function searchPost(){
	var dong = formm.post.value.trim();
	
	if(dong.value==""){
		alert('~동을 입력하여 주십시오.');
		document.formm.id.focus();
	}
	
	console.log(dong.length+'->'+dong);
	window.open('/webapp/PostServlet?dong='+dong,'pop','width=600,height=500');
	
}


function searchPost2(){
	window.open('../../lecture/jspEx/Post.jsp', 'pop', 'width=500,height=500');//세번째 인자값 하나로 묶을 것
	
}
	