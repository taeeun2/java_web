<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	/* div{
		line-height:200%;
	} */

</style>
</head>
<body>
<jsp:include page="../include/Header.jsp"/>
<br>
 <c:set var = "product" value = "${requestScope.product}"></c:set>
	<img src = "http://localhost:8080/webapp/Shopingmall/product_images/${product.image}" width = 200 height = 200  style="float:left; padding: 10px;">
	
	<h2>${product.name}</h2>
	<div>
	���� : ${product.price2}<br>
	���� : <input type = "text" name = "quantity" value = "1"><br>
	������ : ${product.content}<br>
	<input type = "button" value ="��ٱ��Ͽ� ���">
	<input type = "button" value ="��� ����">
	<input type = "button" value ="���">
	</div>
</body>
</html>