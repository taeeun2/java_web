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
<h1>ȸ�� ����</h1>
<form action = "update.do" method = "post">
	��ȣ: <input type = "text" name = "no" value = "${member.getNo()}" readonly><br>
	�̸� : <input type = "text" name = "name" value = "${member.getName()}"><br>
	�̸��� : <input type = "text" name = "email" value = "${member.getEmail()}"><br>
	��ȣ : <input type = "text" name = "password"><br>
	<input type = "submit" value = "�߰�">
	<input type = "reset" value = "���">
</form>
<jsp:include page = "../include/footer.jsp"/>
</body>
</html>