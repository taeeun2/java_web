<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../include/Header.jsp"/>
<div style = "text-align : center; background-color : whitesmoke">
<img src = "http://localhost:8080/webapp/Shopingmall/product_images/w-12.jpg" width = "400" height="300" />
</div>
<br>
<c:set var = "ProductList" value = "${requestScope.product_kinds}"></c:set>
		
			
			<c:forEach var = "Product"  items =  "${ProductList}">
				${Product.name}
			</c:forEach>
			


<%--  <c:set var = "product" value = "${requestScope.product_kinds}"></c:set>
	<img src = "http://localhost:8080/webapp/Shopingmall/product_images/${product.image}" width = 200 height = 200  style="float:left; padding: 10px;">
	
	<h2>${product.name}</h2>
	<div>
	가격 : ${product.price2}<br>
	수량 : <input type = "text" name = "quantity" value = "1"><br>
	상세정보 : ${product.content}<br>
	<input type = "button" value ="장바구니에 담기">
	<input type = "button" value ="즉시 구매">
	<input type = "button" value ="취소">
	</div> --%>

</body>
</html>