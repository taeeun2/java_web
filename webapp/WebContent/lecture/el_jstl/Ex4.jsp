<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>
<body>
<p><a href = "Ex3.jsp">[����]</a><a href = "Ex5.jsp">[����]</a></p>
<h2>c:out �±�</h2>
1) <c:out value = "�ȳ��ϼ���!"/></br>
2) <c:out value = "${null}">�ݰ����ϴ�.</c:out><br>
3) <c:out value = "�ȳ��ϼ���!">�ݰ����ϴ�.</c:out><br>
4) <c:out value = "${null}"/><br>


</body>
</html>