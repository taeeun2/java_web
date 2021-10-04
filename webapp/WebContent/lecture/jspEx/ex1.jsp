<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>안녕하세요, JSP 페이지입니다.</p>
	[스크립트릿(scriptlet)] : 자바코드 구현합니다.
	<br>
	<%
		int su1 = 20;
		int su2 = 10;
		int sum = su1+su2;
		out.println(su1+"+"+su2+"="+sum);
	%><br>
	[선언문(declaration)] : 변수 선언 및 메소드를 정의합니다.
	<br>
	<%!
		String str = "Hello JSP";
		int su1 = 5, su2 = 7;
		
		public int method(){
			return su1+su2;
		}
	%>
	[표현식(expression)] : 문자열 출력합니다.<% out.println("msg"); %>
	<br>
	<%--
		<%= 변수%>
		<%= 수식%>
		<%= 메소드 호출%>
	 --%>
	<%--
		주의)
		<%= 변수;%> 개발자가 작성한 표현식을 (;사용하지 않음)
		웹 컨테이너가 out.print()으로 변환시킴
		out.print(변수;); <- 오류
	  --%>
	  <b><%= method() %></b>
</body>
</html>