<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSON �׽�Ʈ</title>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
      $(function() {
          $("#checkJson").click(function() {
             var jsonStr = '{"age": [22, 33, 44]}';  
             var jsonInfo = JSON.parse(jsonStr);
             var output ="ȸ�� ����<br>";
             output += "=======<br>";
        
             for(var i in jsonInfo.age) {
                output += jsonInfo.age[i]+"<br>";
             }
             $("#output").html(output);
        });
     });
</script>
</head>
<body>
    <a id="checkJson" style="cursor:pointer">���</a><br><br>
    <div id="output"></div>
</body>
</html>