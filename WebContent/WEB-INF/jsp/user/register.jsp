<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Instagram</title>
</head>
<body>
<center>
	ע�����
	<div id="page_register">
		<form action="register" method="post" enctype="multipart/form-data" class="center">
			<div class="form-group">
				<label for="id">�û�ID��</label>
				<input type="text" name="id" id="id"/><br>
			</div>
			<div class="form-group">
				<label for="password">���룺</label>
				<input type="text" name="password"/><br>
			</div>
			<div class="form-group">
				<label for="username">�û��ǳƣ�</label>
				<input type="text" name="username"/><br>
			</div>
			<div class="form-group">
				<label for="website">������ַ��</label>
				<input type="text" name="website"/><br>
			</div>
			<div class="form-group">
				<label for="note">����ǩ����</label>
				<input type="text" name="note"/><br>
			</div>
			<div class="form-group">
				<label for="email">�������䣺</label>
				<input type="text" name="email"/><br>
			</div>
			<div class="form-group">
				<label for="phone">��ϵ��ʽ��</label>
				<input type="text" name="phone"/><br>
			</div>
			<div class="form-group">
				<label for="sex">�Ա�</label>
				<input type="radio" name="sex" value="male">��
				<input type="radio" name="sex" value="female">Ů<br>
			</div>
			<div class="form-group">
				<label for="sex">�ϴ�ͷ��</label>
				<input type="file" name="portrait" id="portrait"/><br>
			</div>
			<input type="submit" class="btn btn-default" value="ע��" />
			<button type="button" class="btn btn-default" id="goBack_login">����</button>
		</form>
	</div>
</center>
</body>
</html>