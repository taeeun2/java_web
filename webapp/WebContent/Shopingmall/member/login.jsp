<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page = "../include/Header.jsp"/>
<form action = "../../NonageServlet?command=login" method = "post">
���̵� : <input type = "text" name = "id">
��й�ȣ : <input type = "text" name = "pwd">

<input type = "submit" value = "�α���">
<input type = "button" value = "ȸ������" >
</form>
</body>
</html>