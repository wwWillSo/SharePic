<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function like(picid) {
		window.location.href="likePic?picid=" + picid + "&flag=self" ;
	}
	function doDelete(picid) {
		if (window.confirm("��ȷ��Ҫɾ������ͼƬ��")) {
			window.location.href="deletePic?picid="+picid + "&flag=self";
			return true ;
		}
		else {
			return false ;
		}
	}
</script>
<body>
	�Լ���ͼƬ
	<c:forEach items="${sessionScope.myPics}" var="pic">
		<img src="${pic.picpath}"/>
		
		<button id="like" value="${pic.picid }" onClick="like(this.value) ;">�7�3</button>
		<form action="commentPic?picid=${pic.picid }&flag=self" method="post">
			<input type="text" name="text">
			<input type="submit" value="����">
		</form>
		<button id="delete" value="${pic.picid }" onClick="doDelete(this.value) ;">ɾ��</button>
	</c:forEach>
</body>
</html>