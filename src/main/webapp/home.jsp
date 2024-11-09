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
					<li><a href="htgioController">Giỏ hàng
					(
					<%= session.getAttribute("giohangCount") != null ? session.getAttribute("giohangCount") : 0 %>
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
				<!-- Hiển thị sách -->
				<%
				ArrayList<Sach> ds = (ArrayList<Sach>)request.getAttribute("dssach");
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					Sach s = ds.get(i);
				%>
				<div class="row">
					<div class="col-md-4">
						<img src="<%=s.getAnh()%>" class="img-fluid img-thumbnail" alt="Responsive image"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> <a
							href="giohangController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
							<button class="btn btn-primary" type="submit">Đặt hàng</button>
						</a>
					</div>
					<%
					i++;
					if (i < n) {
						s = ds.get(i);
					%>
					<div class="col-md-4">
						<img src="<%=s.getAnh()%>" class="img-fluid img-thumbnail" alt="Responsive image"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> <a
							href="giohangController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
							<button class="btn btn-primary" type="submit">Đặt hàng</button>
						</a>
					</div>
					<%
					}
					%>
					<%
					i++;
					if (i < n) {
						s = ds.get(i);
					%>
					<div class="col-md-4">
						<img src="<%=s.getAnh()%>" class="img-fluid img-thumbnail" alt="Responsive image"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> <a
							href="giohangController?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
							<button class="btn btn-primary" type="submit">Đặt hàng</button>
						</a>
					</div>
					<%
					}
					%>
				</div>
				<%
				}
				%>
				
				<!-- Phân trang -->
				<div class="row">
					<nav aria-label="Page navigation example" class="text-center">
						<ul class="pagination justify-content-center">
							<%
            int totalPages = (Integer) request.getAttribute("totalPages"); // tổng số trang
            int currentPage = (Integer) request.getAttribute("currentPage"); // trang hiện tại
            int maxDisplay = 20; // Giới hạn số trang tối đa hiển thị

            // Xử lý nút "<<"
            if (currentPage > 1) {
            %>
							<li><a href="?page=<%= currentPage - 1 %>"><<</a></li>
							<%
            } else {
            %>
							<li class="disabled"><a href="#"><<</a></li>
							<%
            }

            // Hiển thị phân trang rút gọn nếu tổng số trang lớn hơn maxDisplay
            if (totalPages > maxDisplay) {
                // Hiển thị trang đầu
                for (int i = 1; i <= 2; i++) {
                    if (i == currentPage) {
            %>
							<li class="active"><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    } else {
            %>
							<li><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    }
                }
                
                // Hiển thị dấu "..." sau các trang đầu
                if (currentPage > 5) {
            %>
							<li class="disabled"><a href="#">...</a></li>
							<%
                }

                // Hiển thị các trang gần trang hiện tại
                for (int i = Math.max(3, currentPage - 2); i <= Math.min(totalPages - 2, currentPage + 2); i++) {
                    if (i == currentPage) {
            %>
							<li class="active"><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    } else {
            %>
							<li><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    }
                }

                // Hiển thị dấu "..." trước các trang cuối
                if (currentPage < totalPages - 4) {
            %>
							<li class="disabled"><a href="#">...</a></li>
							<%
                }

                // Hiển thị hai trang cuối
                for (int i = totalPages - 1; i <= totalPages; i++) {
                    if (i == currentPage) {
            %>
							<li class="active"><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    } else {
            %>
							<li><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    }
                }

            } else { 
                // Hiển thị toàn bộ các trang nếu tổng số trang <= maxDisplay
                for (int i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
            %>
							<li class="active"><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    } else {
            %>
							<li><a href="?page=<%= i %>"><%= i %></a></li>
							<%
                    }
                }
            }

            // Xử lý nút ">>"
            if (currentPage < totalPages) {
            %>
							<li><a href="?page=<%= currentPage + 1 %>">>></a></li>
							<%
            } else {
            %>
							<li class="disabled"><a href="#">>></a></li>
							<%
            }
            %>
						</ul>
					</nav>
				</div>

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