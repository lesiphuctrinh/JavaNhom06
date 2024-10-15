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
				<a class="navbar-brand" href="home.jsp">PT Shop</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">Trang chủ</a></li>
			       <li><a href="htgio.jsp">Giỏ hàng(0)</a></li>
			       <li><a href="xacnhan.jsp">Xác nhận đặt mua</a></li>
			       <li><a href="lichsu.jsp">Lịch sử mua hàng</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.jsp"><span
							class="glyphicon glyphicon-user"></span> Logout</a></li>
					<%
					if (session.getAttribute("dn") == null) {
					%>
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
					<%
					} else {
					%>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
							Xin chào : <%=session.getAttribute("dn")%></a></li>
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
				LoaiBO lbo = new LoaiBO();
				for (Loai l : lbo.getLoai()) {
				%>
				<a href="home.jsp?ml=<%=l.getMaLoai()%>"> <%=l.getTenLoai()%>
					<hr>
				</a>
				<%
				}
				%>
			</div>
			<div class="col-md-8">
				<!-- Hiển thị sách -->
				<%
				request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng việt
				response.setCharacterEncoding("UTF-8");
				
				SachBO sbo = new SachBO();
				ArrayList<Sach> ds = sbo.getSach();
				
				String ml = request.getParameter("ml"); //tìm kiếm mã loại
				String key = request.getParameter("txttk"); // tìm kiếm sách
				
				if (ml != null)
					ds = sbo.TimMa(ml);
				else if (key != null)
					ds = sbo.Tim(key);
				
				int n = ds.size();
				for (int i = 0; i < n; i++) {
					Sach s = ds.get(i);
				%>
				<div class="row">
					<div class="col-md-4">
						<img src="<%=s.getAnh()%>"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> 
						<a href="giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
							<button class="btn btn-primary" type="submit">Đặt hàng</button>
						</a> 
					</div>
					<%
					i++;
					if (i < n) {
						s = ds.get(i);
					%>
					<div class="col-md-4">
						<img src="<%=s.getAnh()%>"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> 
						<a href="giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
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
						<img src="<%=s.getAnh()%>"> <br>
						<%=s.getTenSach()%>
						<br>
						<%=s.getGia()%>
						<br> 
						<a href="giohang.jsp?ms=<%=s.getMaSach()%>&ts=<%=s.getTenSach()%>&gia=<%=s.getGia()%>">
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
			</div>
			<div class="col-md-2">
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
<body>

</body>
</html>