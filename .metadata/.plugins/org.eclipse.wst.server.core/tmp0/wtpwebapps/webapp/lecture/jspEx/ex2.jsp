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
		int a;			//선언 태그
		int b;			
	%>
	<%
		a = 10;			//실행 태그
		b = 20;
		if(b/a >10){
			
		
	%>
		
		<p style = "color : blue;">
		임의 값(첫 번째)<br>
		<%= "임의 값(두번째)" %><br> <%-- 출력태그 --%>
		<% out.println("다시 양의 값(세번째)"); %>
	<%
		}else{
	%>	
		음의 값
	<% 
		}
	%>
</body>
</html>