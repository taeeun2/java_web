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
<h2>c:set �±�</h2>
<h3>�� ���� ���</h3>
<c:set var = "username1" value="ȫ�浿"/>
<c:set var = "username2">�Ӳ���</c:set>
1) ${username1}<br>
2) ${username2}<br>
<h3>�⺻������ - page</h3>
3) ${pageScope.username1}<br>
4) ${requestScope.username1}<br>
<h3>������ ���� - scope �Ӽ�</h3>
<c:set var="username3" scope="request">������</c:set>
5) ${pageScope.username3}<br>
6) ${requestScope.username3}<br>
<h3>������ �� ���</h3>
<% pageContext.setAttribute("username4","�����屺"); %>
7) ���� �� = $ {username4}<br>
<c:set var ="username4" value = "�ָԴ���"/>
8) ��� �� = ${username4}<br>
<h3>��ü�� ������Ƽ �� ����</h3>
<%!
	public class MyMember{
	private int no;
	private String name;
	
	public int getNo(){
		return no;
	}
	public void setNo(int no){
		this.no = no;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
}

%>
<%
	MyMember member = new MyMember();
	member.setNo(100);
	member.setName("ȫ�浿");
	pageContext.setAttribute("member",member);
	
%>
9) ${member.name}<br>
<c:set target = "${member}" property="name" value ="�Ӳ���"/>
10) ${member.name}<br>
</body>
</html>