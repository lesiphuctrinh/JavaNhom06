
<%@page import="khachhangModal.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="giohangModal.hang"%>
<%@page import="giohangModal.giohangbo"%>
<%@page import="LoaiModal.Loai"%>
<%@page import="LoaiModal.LoaiBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>PT shop</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	session.setAttribute("trang", "home.jsp");
	
 %>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="homeController">PT Shop</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="homeController">Trang chủ</a></li>
					<li><a href="htgioController">Giỏ hàng(0)</a></li>
					<li><a href="xacnhanController">Xác nhận đặt mua</a></li>
					<li><a href="lichsuController">Lịch sử mua hàng</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logoutController"><span
							class="glyphicon glyphicon-user"></span> Logout</a></li>
					<%
					if (session.getAttribute("dn") == null) {
					%>
					<li><a href="loginController"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<%
					} else {
						KhachHang kh = (KhachHang)session.getAttribute("dn");
					%>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Xin chào : <%=kh.getHoten()%></a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<!-- Hiển thị loại -->
				<%
				ArrayList<Loai> dsloai = (ArrayList<Loai>)request.getAttribute("dsloai");
				for (Loai l : dsloai) {
				%>
				<a href="sachController?ml=<%=l.getMaLoai()%>"> <%=l.getTenLoai()%>
					<hr>
				</a>
				<%
				}
				%>
			</div>
			<div class="col-sm-8">
				<form action="xoasuaController" method="post">
					<table class="table table-hover table-bordered">
						<%giohangbo gh=(giohangbo)session.getAttribute("gh");
			           if(gh!=null){
			            for(hang h: gh.ds){%>
						<tr>
							<td><input type="checkbox" name="ck"
								value="<%=h.getMasach()%>"></td>
							<td><%=h.getTensach() %></td>
							<td><%=h.getGia() %></td>
							<td><%=h.getSoluong() %></td>
							<td><input type="number" name="<%=h.getMasach() %>"
								value="0" style="width: 50px" class="form-control">
								<button type="submit" name="butsuasl" value="<%=h.getMasach()%>"
									class="btn btn-warning">Sửa</button></td>
							<td><%=h.getThanhtien()%></td>
							<td class="text-center"><a href="xoasuaController?msxoa=<%=h.getMasach()%>" class="btn btn-danger">
							 	Xóa
							</a></td>
						</tr>

						<% } }
         %>
					</table>
					<input type="submit" name="xoachon" value="Xóa" class="btn btn-danger">
					<input type="submit" name="xoaall" value="Hủy giỏ hàng"
						class="btn btn-danger"> 
						
					<!--<input type="submit" name="xacnhan"> 
						value="Đặt hàng" class="btn btn-primary"> -->
				</form>
				<%if(gh!=null)out.print("Tổng thành tiền: "+ gh.Tong()); %>
				
				<form method="post" action="xacnhanController" class="mt-2">
					<input type="submit" name= "but" value="Xác nhận" class="btn btn-primary" > 
				</form>
								
			</div>
			<div class="col-sm-2">
				<!-- Tìm kiếm -->
				<form action="home.jsp" method="post">
					<div class="input-group">
						<input type="text" name="txttk" class="form-control" placeholder="Search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</form>

			</div>
		</div>
	</div>

</body>
</html>
