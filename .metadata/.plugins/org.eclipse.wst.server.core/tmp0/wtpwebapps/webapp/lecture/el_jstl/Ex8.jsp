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
<h2>c:choose �±�</h2>
<c:set var="userid" value = "admin"/>
<c:choose>
	<c:when test = "${userid == 'hong'}">
		ȫ�浿�� �ݰ����ϴ�.
	</c:when>
	<c:when test = "${userid == 'leem' }">
		�Ӳ����� �ݰ����ϴ�.
	</c:when>
	<c:when test = "${userid == 'admin' }">
		������ ���� �������Դϴ�.
	</c:when>
	<c:otherwise>
		��ϵ��� ���� ������Դϴ�.
	</c:otherwise>
</c:choose>
</body>
</html>