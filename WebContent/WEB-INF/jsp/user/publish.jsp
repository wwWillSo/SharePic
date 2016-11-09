<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${sessionScope.user.username}"></c:out>
	
	<form action="publish" method="post" enctype="multipart/form-data">
		上传图片：<input type="file" name="picture"/><br>
		
		<input type="submit" value="上传"/>	
	</form>
</body>
</html>