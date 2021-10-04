<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Update</title>
</head>
<jsp:include page = "../include/header.jsp"/>
<h1>회원 수정</h1>
<form action = "update.do" method = "post">
	번호: <input type = "text" name = "no" value = "${member.getNo()}" readonly><br>
	이름 : <input type = "text" name = "name" value = "${member.getName()}"><br>
	이메일 : <input type = "text" name = "email" value = "${member.getEmail()}"><br>
	암호 : <input type = "text" name = "password"><br>
	<input type = "submit" value = "추가">
	<input type = "reset" value = "취소">
</form>
<jsp:include page = "../include/footer.jsp"/>
</body>
</html>