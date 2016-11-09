<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Instagram</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
</head>
<script type="text/javascript">
//function like(picid) {
//	window.location.href="likePic?picid=" + picid;
//}
function doDelete(picid) {
	if (window.confirm("你确定要删除这张图片吗？")) {
		window.location.href="deletePic?picid="+picid;
		return true ;
	}
	else {
		return false ;
	}
}
</script>
<script>
$(document).ready(function(){
	
	
	$("img").each(function(i) {
		$(this).css({"width":600}) ;
		
		$(this).click(function () {
			//点击之后用页面详情去代替div(id=picArea)
			
			$("#picInfo").hide("slow") ;
			
			//location.reload() ;
			//location.href = "userLogin?id=WillSo&password=123" ;
			
			$.ajax({
				url:"userLogin?id="+ "${sessionScope.user.getUserid()}" +"&password=" + "${sessionScope.user.getPassword()}"
							+ "&all_or_my=" + $("#all_or_my").val(),
				success:function(result) {
					$("body").html(result) ;
				}
			})
		})
		
	})
	
	$("#like").click(function () {
		$.ajax({
			url:"likePic?picid=" + this.value ,
			success:function (result) {
				$("#picInfo").html(result);
			}
		})
	})
	
	$("#comment").click(function () {
		$.ajax({
			url : "commentPic?picid=" + this.value + "&text=" + $("#text").val(),
			success : function(result) {
				$("#picInfo").html(result);
			}
		})
		
	})
	
	$("#delete").click(function () {
		confirm("确定要删除吗？") ;
		$.ajax({
			url: "deletePic?picid=" + this.value,
			success : function (result) {
				alert("删除成功！") ;
			} 
		})
		//location.reload(true) ;
		$.ajax({
			url:"userLogin?id="+ "${sessionScope.user.getUserid()}" +"&password=" + "${sessionScope.user.getPassword()}"
						+ "&all_or_my=" + $("#all_or_my").val(),
			success:function(result) {
				$("body").html(result) ;
			}
		})
	})
	
	$("#show").css({"margin-left":320}) ;
});
</script>
<body>
	<div id="show">
	<img src="${requestScope.selectedPic.picpath } " class="img-responsive img-thumbnail" title="赞：${requestScope.selectedPic.like.size() }，评论：${requestScope.selectedPic.comment.size() }"><br>
	
	<!-- 点赞用户 -->
	<c:if test="${requestScope.allLikes.size() != 0 }">
	<c:forEach items="${requestScope.allLikes}" var="userid" varStatus="statue">
		<font style="color: yellow;">${userid},</font>
	</c:forEach><font style="color: white">等用户点了赞</font><br>
	</c:if>
	
	<!-- 评论 -->
	<c:if test="${requestScope.allComments.size() != 0 }">
	<c:forEach items="${requestScope.allComments }" var="comment" varStatus="statue">
		<font style="color: brown;">${comment.user.getUserid()}：</font>
		<font style="color: white;">${comment.note }</font><br>
	</c:forEach>
	</c:if>
	
	<c:choose>
		<c:when test="${requestScope.like_red == true }">
			<button id="like" value="${requestScope.selectedPic.picid }"><font color="red">♥</font></button>
		</c:when>
		<c:otherwise>
			<button id="like" value="${requestScope.selectedPic.picid }"><font color="blue">♥</font></button>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${requestScope.delete_flag == true }">
		<button id="delete" value="${requestScope.selectedPic.picid }">删除</button>
	</c:if>
	
		<input type="text" name="text" id="text"/>
		<button id="comment" value="${requestScope.selectedPic.picid }">评论</button>
	</div>
</body>
</html>