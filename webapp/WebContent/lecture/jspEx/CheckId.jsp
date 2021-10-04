<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "db.DBAction, java.sql.*, dto.UserInfo"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <jsp:useBean id = "userinfo" class = "dto.UserInfo" scope = "request"/>
 --%>
 <% UserInfo userinfo = (UserInfo)request.getAttribute("userinfo"); %>
 <body>
<%-- <%!
	Connection conn = DBAction.getInstance().getConnection();
%>
<%
 	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");//공백 삭제 .trim()
	String sql = "SELECT ID FROM USERINFO WHERE ID = ?";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	UserInfo userinfo = null;
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			userinfo = new UserInfo().setId(rs.getString("ID"));	
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%> --%>
<br><p><center><hr><br><p><!-- 중앙으로 출력하겠다 -->

<% if(userinfo != null){ %>
	<%= userinfo.getId() + "는 사용할 수 없는 아이디입니다." %>
	<input type = 'button' value='닫기' onclick = 'window.close()'/>
<%} else{ %>
	<%= request.getParameter("id")+"는 사용가능한 아이디 입니다." %>
		<input type = 'button' value='닫기' onclick = 'window.close()'/>
<% } %>
</body>
</html>