<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	table{
	width : 100%;
	border-collapse : collapse;
	text-align : center;
	border : 5px solid #444444;
	}
	th, td{
		padding: 10px;
		border-bottom : 2px solid #444444;
	}
	.title{
		 align : center;
		 background-color : slateblue;
		 color : white;
		 border-bottom : double black;
		 
	}
	th{
		background-color : ivory;
	}
	th:first-child, td:first-child {
		border : none;
	}
	
</style>
</head>
<body>
	<%!
		int sum;
		Calendar cal;
	%>
	<%
		cal = Calendar.getInstance();
		String[] yoil = {"��","��","ȭ","��","��","��","��"};
	%>
	
	<table border='1'>
	<tr><td colspan = '9' class = "title" >������</td></tr>
	<tr>
	<%	
	
	for(int i=2;i<10;i++){
		out.println("<th>"+i+"��"+"</th>");
	}
	
	for(int i=1;i<10;i++) {
		if(i%2==0){
		%><tr><% 
		}else{
	%>
			<tr style = "background-color : mistyrose">
			<%}
			for(int j=2;j<10;j++) {
				out.println("<td>" + j + " * "+i+"="+(j*i)+"</td>");
			}			
	}%>
	</table>
	<%
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int day = cal.get(Calendar.DAY_OF_WEEK);
	 %>
	 <%= year + "�� " + month + "�� " + date + "�� "+hour+"�� "+minute+"�� "+second
	 	+"�� �Դϴ�. (������ \"" + yoil[day-1]+"\"���� �Դϴ�.)"%>	 
</body>
</html>