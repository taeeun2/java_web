<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a;			//���� �±�
		int b;			
	%>
	<%
		a = 10;			//���� �±�
		b = 20;
		if(b/a >10){
			
		
	%>
		
		<p style = "color : blue;">
		���� ��(ù ��°)<br>
		<%= "���� ��(�ι�°)" %><br> <%-- ����±� --%>
		<% out.println("�ٽ� ���� ��(����°)"); %>
	<%
		}else{
	%>	
		���� ��
	<% 
		}
	%>
</body>
</html>