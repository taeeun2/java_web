<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<p><a href="login.do">로그인하기</a></p>
	<form  action = "login.do" method = "post">
		아이디 : <input  type = "text" name = "email" size = "10" ><br>
		비밀번호 : <input type = "password" name = "password" size = "10"><br>
		<input class = "btn1" type = "submit" value = "로그인"><input class = "btn2" type = "reset" value ="취소">
	</form>
</body>
</html>