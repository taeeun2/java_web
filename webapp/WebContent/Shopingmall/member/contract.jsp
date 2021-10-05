<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- <%@ include file = "../include/header.jsp" %> --%>
<%@ include file = "sub_menu.html" %>
<style>
	article{
		
		position : relative;
		left : 30%;
	}
	div{
		position : absolute;
	}

</style>


<article>
	<h2>Join Us</h2>
	<form id = "join" action = "NonageServlet?command=join_form"method="post" name = "formm">
		<br>
		~~
		<br>
		<!-- <textarea rows="15" cols="100">
		
		
		</textarea> -->
		<div>
		<input type = "radio" name = "okon1" checked> 동의함
		<input type = "radio" name = "okon1" checked> 동의안함
		</div>
		<input type = "button" value="Next" class="submit" onclick="go_next()" style="float:right;">
	</form>
</article>