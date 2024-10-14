<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--tạo form đăng nhập --%>
	<% 
    String username = request.getParameter("dangnhap");
    String password = request.getParameter("matkhau");
	boolean error = false;

    if ("abc".equals(username) && "123".equals(password)) {
        response.sendRedirect("http://ums.husc.edu.vn");
    } else {
			error = true;
    } %>
    <% if (error) { %>
   			 <p style='color:red;'>Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại!</p>
	<% } %>
	<h2>SINH VIÊN</h2>
	<form action="bai1.jsp" method="post">
		<label for="dangnhap">Tên đăng nhập:</label> <br>
		<input type="text" name="dangnhap" placeholder="Mã sinh viên/Email"> <br>
		<label for="matkhau">Mật khẩu:</label> <br>
		<input type="text" name="matkhau" placeholder="Mật khẩu"> <br> <br>
		<input type="submit" value="Đăng nhập">
	</form>
	
</body>
</html>