<%@page import="lichsuModal.lichsu"%>
<%@page import="khachhangModal.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@page import="SachModal.Sach"%>
<%@page import="SachModal.SachBO"%>
<%@page import="LoaiModal.Loai"%>
<%@page import="LoaiModal.LoaiBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>PT Shop</title>
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
	session.setAttribute("trang", "homeController");
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
					<li><a href="htgioController">Giỏ hàng ( <%= session.getAttribute("giohangCount") != null ? session.getAttribute("giohangCount") : 0 %>
							)
					</a></li>
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
			<div class="col-md-8">
				<form action="lichsuController" method="post">
					<!-- Bảng Lịch Sử Mua Hàng -->
					<div class="container-fluid">
						<h1>Lịch Sử Mua Hàng</h1>
						<table class="table table-bordered mt-3 table-hover table-responsive">
							<thead>
								<tr>
									<th>Tên sách</th>
									<th>Số lượng</th>
									<th>Giá</th>
									<th>Đã mua</th>
									<th>Ngày mua</th>
									<th>Thành tiền</th>
								</tr>
							</thead>
							<tbody>
								<!-- Dữ liệu sẽ được lấy từ cơ sở dữ liệu -->
								<%
                    ArrayList<lichsu> ds = (ArrayList<lichsu>) request.getAttribute("dslichsu");
                    int n = ds.size();
                    if (ds != null && ds.size() > 0) {
                        for (lichsu ls: ds) {
                    %>
								<tr>
									<td><%= ls.getTenSach() %></td>
									<td><%= ls.getSoLuongMua()%></td>
									<td><%= String.format("%,d VND", (int) ls.getGia()) %></td>
									<td><%= ls.isDaMua() ? "Đã thanh toán" : "Chưa thanh toán" %></td>
									<td><%= ls.getNgayMuaFormat() %></td>
									<td><%= String.format("%,d VND", (int) ls.getThanhTien()) %></td>
								</tr>
								<%
                        }
                    } else {
                    %>
								<tr>
									<td colspan="6" style="text-align: center;">Không có lịch
										sử mua hàng</td>
								</tr>
								<%
                    }
                    %>
							</tbody>
						</table>
					</div>

				</form>
				</div>
				<div class="col-md-2">
					<!-- Tìm kiếm -->
					<form action="sachController" method="post">
						<div class="input-group">
							<input type="text" name="txttk" class="form-control"
								placeholder="Search">
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
		<body>

		</body>
</html>
