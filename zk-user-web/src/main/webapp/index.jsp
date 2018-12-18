<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<!-- 解决跳转页面无法加载静态资源文件问题 -->
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
111
<!-- <img alt="" src="static/image/2.png"> -->
<input value="AJAX" type="button" onclick="ajaxTest();"/>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
function ajaxTest(){
	  $.ajax({
             type: "post",
             url: "user/testAjax",
             data: {'userName':"Alan"},
             dataType: "json",
             success: function(data){
                   console.log(data.code);    
             }
       });
}
</script>
</html>