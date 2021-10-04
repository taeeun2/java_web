<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.util.*" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL</title>
</head>
<body>
<h2>c:forEach �±�</h2>
<h3>�ݺ��� - �迭</h3>
<% pageContext.setAttribute("nameList", new String[]{"ȫ�浿","�Ӳ���","������"}); %>
<ul>
	<c:forEach var = "name"  items =  "${nameList}">
		<li>${name}</li>
	</c:forEach>
</ul>
<h3>�ݺ��� - �迭�� ���� �ε����� ���� �ε��� ����</h3>
<% pageContext.setAttribute("nameList2", new String[]{"ȫ�浿","�Ӳ���","������", "�ָԴ���","�����屺"}); %>
<ul>
	<c:forEach var = "name"  items =  "${nameList2}" begin = "2" end = "3">
		<li>${name}</li>
	</c:forEach>
</ul>
<h3>�ݺ��� - ArrayList ����</h3>
<%
	ArrayList<String> nameList3 = new ArrayList<String>();
	nameList3.add("ȫ�浿");
	nameList3.add("�Ӳ���");
	nameList3.add("������");
	nameList3.add("�ָԴ���");
	nameList3.add("�����屺");
	pageContext.setAttribute("nameList3",nameList3);
%>
<ul>
	<c:forEach var = "name" items = "${nameList}">
		<li>${name}</li>
	</c:forEach>
</ul>
<h3>�ݺ��� - Ư�� Ƚ����ŭ �ݺ�</h3>
<c:forEach var = "no" begin = "1" end = "6">
	<li><a href = "Ex${no}.jsp">���� ${no}</a></li>
</c:forEach>
<h3>�ݺ��� - �޸��� ���е� ���ڿ�</h3>
<% pageContext.setAttribute("nameList4", "ȫ�浿,�Ӳ���,������,�ָԴ���,�����屺"); %>
<c:forEach var = "name" items = "${nameList4}">
	<li>${name}</li>
</c:forEach>
</body>
</html>