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
        var jsonStr  = '{"name": ["ȫ�浿", "�̼���", "�Ӳ���"] }';          
        var jsonInfo = JSON.parse(jsonStr);
        //���������� JSON����� parse()�޼��带 �̿��� JSON �ڷ����� �����ɴϴ�.
        var output ="ȸ�� �̸�<br>";
        output += "=======<br>";
        for(var i in jsonInfo.name) {
            output += jsonInfo.name[i]+"<br>";
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