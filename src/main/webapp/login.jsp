<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SINH VIÊN</h2>
	<form action="loginController" method="post">
		<label for="dangnhap">Tên đăng nhập:</label> <br>
		<input type="text" name="dangnhap" placeholder="Mã sinh viên/Email"> <br>
		<label for="matkhau">Mật khẩu:</label> <br>
		<input type="text" name="matkhau" placeholder="Mật khẩu"> <br> <br>
		<input type="submit" value="Đăng nhập">
	</form>
	
</body>
</html>