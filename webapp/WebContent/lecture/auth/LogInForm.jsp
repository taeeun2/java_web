<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/webapp/UserInfoLoginServlet" method="post">
		아이디 : <input  type = "text" name = "id" size = "10" ><br>
		비밀번호 : <input type = "password" name = "pw" size = "10"><br>
		<input class = "btn1" type = "submit" value = "로그인"><input class = "btn2" type = "reset" value ="취소">
	</form>
</body>
</html>