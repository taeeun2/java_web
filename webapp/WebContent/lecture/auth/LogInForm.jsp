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
		���̵� : <input  type = "text" name = "id" size = "10" ><br>
		��й�ȣ : <input type = "password" name = "pw" size = "10"><br>
		<input class = "btn1" type = "submit" value = "�α���"><input class = "btn2" type = "reset" value ="���">
	</form>
</body>
</html>