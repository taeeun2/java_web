<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "../include/header.jsp"/>
<h1>ȸ�� ���___</h1>
<form action = "add.do" method = "post">
	�̸� : <input type = "text" name = "name"><br>
	�̸��� : <input type = "text" name = "email"><br>
	��ȣ : <input type = "text" name = "password"><br>
	<input type = "submit" value = "�߰�">
	<input type = "reset" value = "���">
</form>
<jsp:include page = "../include/footer.jsp"/>
</body>
</html>