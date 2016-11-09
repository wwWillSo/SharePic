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
<script>
$(document).ready(function(){
	if ("${requestScope.all_or_my}" == "all") {
		$("#myPicArea").hide() ;
		$("#picArea").show() ;
		
		$("#select_showAllPic").attr("class", "active") ;
		$("#select_showMyPic").attr("class", "") ;
	} else {
		$("#picArea").hide() ;
		$("#myPicArea").show() ;
		
		$("#select_showMyPic").attr("class", "active") ;
		$("#select_showAllPic").attr("class", "") ;
	}
	$("img").each(function(i) {
		$(this).mouseover(function () {
			//$(this).replaceWith("<img src=" + this.src + ">") ;
			//$("#small2Big").html("<img src=" + this.src + ">") ;
			//$("#small2Big").show("slow") ;
			
			$(this).css({"width":this.width*2}) ;
			$(this).css({"margin-left":-30}) ;
			//$("#like_" + this.id).fadeIn("slow") ;
			//$("#comment_" + this.id).fadeIn("slow") ;
		}) ;
		$(this).mouseleave(function() {
			$(this).css({"width":230}) ;
			
			$(this).css({"margin-left":65}) ;
			//$("#like_" + this.id).fadeOut("slow") ;
			//$("#comment_" + this.id).fadeOut("slow") ;
			//alert(this.id) ;
		})
		
		$(this).click(function () {
			//点击之后用页面详情去代替div(id=picArea)
			$("#picArea").hide("slow") ;
			$("#myPicArea").hide("slow") ;
			
			$.ajax({url:"showPicInfo.do?picid=" + this.id,
	    		success:function(result){
	    			$("#picInfo").html(result);
					
   				 }
	    	});
		})
		
		$(this).css({"width":230}) ;
		$(this).css({"margin-left":65}) ;
	})
	// $(window).scroll(function() {
    //     $('#small2Big').css("top", $(window).scrollTop()+80)
    // });
	$("#show_all_pic").click(function(){
		$("#all_or_my").val("all") ;
		//$("#select_showAllPic").attr("class", "active") ;
		//$("#select_showMyPic").attr("class", "") ;
		
		//$("#myPicArea").hide("slow") ;
		//$("#picArea").show("slow") ;
		
		$.ajax({
			url:"userLogin?id="+ "${sessionScope.user.getUserid()}" +"&password=" + "${sessionScope.user.getPassword()}"
						+ "&all_or_my=" + $("#all_or_my").val(),
			success:function(result) {
				$("body").html(result) ;
			}
		})
	})
	
	$("#show_my_pic").click(function(){
		$("#all_or_my").val("my") ;
		//$("#select_showMyPic").attr("class", "active") ;
		//$("#select_showAllPic").attr("class", "") ;
		
		//$("#picArea").hide("slow") ;
		//$("#myPicArea").show("slow") ;
		
		$.ajax({
			url:"userLogin?id="+ "${sessionScope.user.getUserid()}" +"&password=" + "${sessionScope.user.getPassword()}"
						+ "&all_or_my=" + $("#all_or_my").val(),
			success:function(result) {
				$("body").html(result) ;
			}
		})
	})
	
});
</script>
<body style="background-color:black; padding-top: 50px; padding-bottom: 60px; padding-left:110px;">
	<nav class="navbar navbar-inverse navbar-fixed-bottom">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
		<a class="navbar-brand" href="#">Brand</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	  	    <li class="active" id="select_showAllPic"><a id="show_all_pic">所有图片<span class="sr-only">(current)</span></a></li> 
	        <li id="select_showMyPic"><a id="show_my_pic">自己的图片</a></li>
	        <li id="select_publish"><a href="publish.do">发布图片</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	
	<input type="hidden" id="all_or_my" value="${requestScope.all_or_my }"/>
	
	<div style="display:inline;" id="picArea">
	<c:forEach items="${sessionScope.allPics}" var="pic" varStatus="statue">
			<img src="${pic.picpath}" class="img-responsive img-thumbnail" style="" id="${pic.picid }" title="赞：${pic.like.size() }，评论：${pic.comment.size() }"/>
		<!-- <span id="like_${pic.picid }">赞：${pic.like.size() }，评论：${pic.comment.size() }</span>  -->
	</c:forEach>
	</div>
	
	<div style="display:inline;" id="myPicArea">
	<c:forEach items="${sessionScope.myPics}" var="pic" varStatus="statue">
			<img src="${pic.picpath}" class="img-responsive img-thumbnail" style="" id="${pic.picid }" title="赞：${pic.like.size() }，评论：${pic.comment.size() }"/>
		<!-- <span id="like_${pic.picid }">赞：${pic.like.size() }，评论：${pic.comment.size() }</span>  -->
	</c:forEach>
	</div>
	
	<div id="picInfo">
	
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>