<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Yeon+Sung&display=swap" rel="stylesheet">

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>

	.title{
		font-size : 35px;
	    float: right;
    	position: relative;
   		left: -50%;
   		margin-top : 20px;
   		font-family: 'Yeon Sung', cursive;
	}
	*{
		text-decoration: none;
		color : black;
	}
	.a1{
		
		font-size : 12px;
		margin : 5px;
		font-family: 'Yeon Sung', cursive;
	}
	
	.a2{
		font-size : 20px;
		margin : 15px;
		/* color : slateblue; */
	    font-family: 'Poppins',Malgun Gothic, '���� ����', Dotum, '����', sans-serif;
	/* 	font-family: 'Black Han Sans', sans-serif; */
	}
	
</style>

<script type="text/javascript" src="member.js" charset="utf-8"></script>
</head>
<%-- session �߰��ϱ� --%>
<body>
<div>
		<a class = "title" href = "http://localhost:8080/webapp/NonageServlet?command=index" >���θ�</a>
</div>
<div style = "height:80px;">

<!-- <div style = "height:80px; padding : 5px;">

<!-- <div style="background-color:lavender;
 height:80px; padding : 5px;"> -->
		<span style="float:right;"><%--������ ����--%>
		<a class = "a1" href = "#" >LOGIN(CUSTOMER | ADMIN)</a>
		<a class = "a1" href = "http://localhost:8080/webapp/Shopingmall/member/join.jsp" >JOIN</a>
		<a class = "a1" href = "#" >CART</a>
		<a class = "a1" href = "#" >MY PAGE</a>
		<a class = "a1" href = "#" >Q&A(1:1)</a>
		</span>

		<br><br>
		<span style="float:right;"><%--������ ����--%>
		<a class = "a2" href = "http://localhost:8080/webapp/Shopingmall/product_show/Heels.jsp" >Heels</a>
		<a class = "a2" href = "#" >Boots</a>
		<a class = "a2" href = "#" >Sandals</a>
		<a class = "a2" href = "#" >Sneakers</a>
		<a class = "a2" href = "#" >On Sale</a>
		</span>
	
	<%--<% } --%>
</div>
<hr>
</body>
</html>