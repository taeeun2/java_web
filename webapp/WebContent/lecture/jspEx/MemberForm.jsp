<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script type = "text/javascript">
	function fn_sendMember(){
		//alert("fn_sendMember()");
 		var frmMember = document.frmMember;
 		var id = frmMember.id.value.trim();
		var pwd = frmMember.pwd.value.trim();
		var name = frmMember.name.value.trim();
		var email = frmMember.email.value.trim();
		var post = frmMember.post.value.trim();
	//	document.getElementById("name").value = 'val';
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
			frmMember.method = "post";
			frmMember.action = "UserInfoAddServlet";
			frmMember.submit();
		}
 	}
	
	function idCheck(){
 		//var frmMember = document.frmMember;
		var id = frmMember.id.value;
		if(id.length == 0 || id == '')
			alert("아이디는 필수입니다.");
		else{
			//팝업창
			window.open('CheckIdServlet?id='+id, 'pop', 'width=300,height=300');//세번째 인자값 하나로 묶을 것
		}
	}
	
	function searchPost(){
		var post = frmMember.post.value;
		window.open('jspEx/Post.jsp', 'pop', 'width=500,height=500');//세번째 인자값 하나로 묶을 것
		
		
	}
	
	function searchPost(){
		var dong = frmMember.post.value.trim();
		console.log(dong.length+'->'+dong);
		if(dong.length == null || dong == '')
			alert("~동을 입력해주세요");
		else{
			window.open('/webapp/PostServlet?dong='+dong,'pop','width=600,height=500');
		}
	
	}
</script>
<body>
<jsp:include page="../include/header.jsp"/>

<%--  <%@ include file = "../include/header.jsp" %>	--%> 
 <form name = "frmMember">
	<table>
		<th> 회원 가입창</th>
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "id">
<!-- 				<input type = "button" value = "아이디 중복체크" onclick = "location.href = '/webapp/jspEx/CheckId.jsp?id =12'">
-->			<input type = "button" value = "아이디 중복체크" onclick = "idCheck()"></td>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "pwd"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" name = "email"></td>
		</tr>
		<!-- 추가 -->
		<tr>
			<td>우편번호</td>
			<td><input type = "text" name = "post">
			<input type = "button" value = "우편번호 검색", onclick = "searchPost()">
			</td>
		</tr>
		
	</table>
	<input type = "button" value = "가입하기" onclick = "fn_sendMember()">
	<input type = "reset" value = "다시입력">
	<input type = "hidden" name = "command" value = "addMember">
	</form>
	<jsp:include page="../include/footer.jsp"/>
</body>
</html>