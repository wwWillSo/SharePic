<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<script>
	function a() {
		alert("==") ;
	}
</script>
</head>
<body style="background-color: brown;" onload="a()">
	<jsp:forward page="/WEB-INF/index.jsp"/>
</body>
</html>