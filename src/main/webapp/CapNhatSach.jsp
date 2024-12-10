<%@page import="LoaiModal.Loai"%>
<%@page import="sachAdminModal.sachAdmin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>PT Shop</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="adminController">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">LSPT SHOP</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="adminController">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Trang chủ</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link" href="sachAdminController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Quản lý sách</span></a>
            </li>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="loaiAdminController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Quản lý loại</span></a>
            </li>
			
			<li class="nav-item">
                <a class="nav-link" href="xacnhanAdminController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Quản lý đơn hàng</span></a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

  					<!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Activity Log
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>	
                <!-- End of Topbar -->
	                <!-- Begin Page Content -->
                <div class="container-fluid">
				<h2 class="mb-4">Cập Nhật Thông Tin Sách</h2>
				<!-- Hiển thị thông báo -->
	        <% String message = (String) request.getAttribute("errorMessage");
	           if (message != null) { %>
	            <div class="alert alert-danger" role="alert">
	                <%= message %>
	            </div>
	        <% } %>
        <form action="capnhatSachController" method="post" enctype="multipart/form-data">
            <!-- Ảnh -->
            <div class="mb-3">
                <label for="bookImage" class="form-label">Ảnh</label>
                <input type="file" class="form-control" id="bookImage" name="anh" accept="image/*" required>
            </div>
            
			<!-- Mã sách -->
            <div class="mb-3">
                <input type="hidden" class="form-control" id="bookName" name="maSach" placeholder="Nhập mã sách" value="<%= request.getParameter("maSach") %>" readonly>
            </div>
            
            <!-- Tên sách -->
            <div class="mb-3">
                <label for="bookName" class="form-label">Tên Sách</label>
                <input type="text" class="form-control" id="bookName" name="tenSach" placeholder="Nhập tên sách" required>
            </div>

            <!-- Tác giả -->
            <div class="mb-3">
                <label for="author" class="form-label">Tác Giả</label>
                <input type="text" class="form-control" id="author" name="tacGia" placeholder="Nhập tên tác giả" required>
            </div>

            <!-- Số lượng -->
            <div class="mb-3">
                <label for="quantity" class="form-label">Số Lượng</label>
                <input type="number" class="form-control" id="quantity" name="soLuong" placeholder="Nhập số lượng" min="1" required>
            </div>

            <!-- Giá -->
            <div class="mb-3">
                <label for="price" class="form-label">Giá</label>
                <input type="number" class="form-control" id="price" name="gia" placeholder="Nhập giá sách" min="0" required>
            </div>
			
			<!-- Mã Loại -->
            <div class="mb-3">
                <label for="author" class="form-label">Mã Loại</label>
				<select class="form-control" name="maLoai">
				    <option value="">--Chọn mã loại--</option>
					<% 
					ArrayList<Loai> dsloai = (ArrayList<Loai>) request.getAttribute("dsloai");
					if (dsloai != null && !dsloai.isEmpty()) {
					    for (Loai l : dsloai) {
					%>
					        <option value="<%= l.getMaLoai() %>"><%= l.getTenLoai() %></option>
					<% 
					    } 
					} else { 
					%>
					        <option value="">Không có loại sách nào</option>
					<% 
					} 
					%>
					</select>
            </div>
            

            <div class="d-flex justify-content-end">
			    <button type="submit" class="btn btn-primary">Lưu Thông Tin</button>
			    <a href="sachAdminController" class="btn btn-secondary" style="margin-left: 15px;">Quay lại</a>	
			</div>
        </form>
              
	       <!-- /.container-fluid -->
				
            </div>

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Lê Sĩ Phúc Trình 2024</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Đăng xuất?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Bạn có chắc chắn muốn đăng xuất tài khoản này không.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Không</button>
                    <a class="btn btn-primary" href="loginAdmin.jsp">Có</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>