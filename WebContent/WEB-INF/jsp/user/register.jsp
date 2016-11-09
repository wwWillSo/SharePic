<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Instagram</title>
</head>
<body>
<center>
	注册界面
	<div id="page_register">
		<form action="register" method="post" enctype="multipart/form-data" class="center">
			<div class="form-group">
				<label for="id">用户ID：</label>
				<input type="text" name="id" id="id"/><br>
			</div>
			<div class="form-group">
				<label for="password">密码：</label>
				<input type="text" name="password"/><br>
			</div>
			<div class="form-group">
				<label for="username">用户昵称：</label>
				<input type="text" name="username"/><br>
			</div>
			<div class="form-group">
				<label for="website">个人网址：</label>
				<input type="text" name="website"/><br>
			</div>
			<div class="form-group">
				<label for="note">个性签名：</label>
				<input type="text" name="note"/><br>
			</div>
			<div class="form-group">
				<label for="email">电子邮箱：</label>
				<input type="text" name="email"/><br>
			</div>
			<div class="form-group">
				<label for="phone">联系方式：</label>
				<input type="text" name="phone"/><br>
			</div>
			<div class="form-group">
				<label for="sex">性别：</label>
				<input type="radio" name="sex" value="male">男
				<input type="radio" name="sex" value="female">女<br>
			</div>
			<div class="form-group">
				<label for="sex">上传头像：</label>
				<input type="file" name="portrait" id="portrait"/><br>
			</div>
			<input type="submit" class="btn btn-default" value="注册" />
			<button type="button" class="btn btn-default" id="goBack_login">返回</button>
		</form>
	</div>
</center>
</body>
</html>