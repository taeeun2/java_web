<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	p{
	text-align : center;
	font-size : 25px;
	color : black;
	font-family: 'Yeon Sung', cursive;	}
	
	th, td{
		padding: 10px;
		
	}
		
	td{
		text-align: center;
		font-family: 'Yeon Sung', cursive;
	}
	.mainimage{
		width : 100%;
	}
</style>
</head>
<body>
<jsp:include page="../include/Header.jsp"/>

<%-- <div style="float:left">
	<jsp:include page="../include/nav.jsp"/>
</div> --%>
<img class = "mainimage" src = "http://localhost:8080/webapp/Shopingmall/images/mainbanner.jpg"/>
<p>New Item</p>
<div style = "background-color : whitesmoke">
	<br>
<!-- <form id = "join" action = "NonageServlet?command=join" method="post"name="formm"> -->
	<c:set var = "newProductList" value = "${requestScope.newProductList}"></c:set>
			<table>
			<tr>
			<c:forEach var = "newProduct"  items =  "${newProductList}">
				<td><img src = "http://localhost:8080/webapp/Shopingmall/product_images/${newProduct.image}" width = 200 height = 200></td>
			</c:forEach>
			</tr>
			<tr>
			<c:forEach var = "newProduct"  items =  "${newProductList}">
				<td>${newProduct.name}</td>
			</c:forEach>
			</tr>
			<tr>
			<c:forEach var = "newProduct"  items =  "${newProductList}">
				<td>${newProduct.price2}</td>
			</c:forEach>
			</tr>
			</table>
</div>	
<p>Best Item</p>
<div style = "background-color : whitesmoke">
<br>

	<c:set var = "bestProductList" value = "${requestScope.bestProductList}"></c:set>
		<table>
			<tr>
			<c:forEach var = "bestProduct"  items =  "${bestProductList}">
				<td><img src = "http://localhost:8080/webapp/Shopingmall/product_images/${bestProduct.image}" width = 200 height = 200></td>
			</c:forEach>
			</tr>
			<tr>
			<c:forEach var = "bestProduct"  items =  "${bestProductList}">
				<td>${bestProduct.name}</td>
			</c:forEach>
			</tr>
			<tr>
			<c:forEach var = "bestProduct"  items =  "${bestProductList}">
				<td>${bestProduct.price2}</td>
			</c:forEach>
			</tr>
			</table>

</div>

</body>
</html>