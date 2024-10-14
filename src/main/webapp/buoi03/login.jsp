<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%--tạo form đăng nhập --%>
		<% 
	    String username = request.getParameter("dangnhap");
	    String password = request.getParameter("matkhau");
		String tb = null;
		if(username != null && password != null){
			if ("abc".equals(username) && "123".equals(password)) {
				session.setAttribute("dn", username);
		        response.sendRedirect("home.jsp");
		    }  else
		    		tb = "Đăng nhập sai. Vui lòng nhập lại!";
		}
	    %>
	<!-- The Modal -->
	<div class="modal fade" id="myModal">
	  <div class="modal-dialog">
	    <div class="modal-content text-center p-2">
			<h2>SINH VIÊN</h2>
			<form action="login.jsp" method="post">
				<label for="dangnhap">Tên đăng nhập:</label> <br>
				<input type="text" name="dangnhap" placeholder="Mã sinh viên/Email"> <br>
				<label for="matkhau">Mật khẩu:</label> <br>
				<input type="text" name="matkhau" placeholder="Mật khẩu"> <br> <br>
				<input type="submit" value="Đăng nhập">
			</form>
	    </div>
	  </div>
	</div>
	
	<script>
	  window.onload = function() {
	    var myModal = new bootstrap.Modal(document.getElementById('myModal'));
	    myModal.show();
	  };
	</script>
</body>
</html>