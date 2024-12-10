<%@page import="xacnhanAdminModal.xacnhan"%>
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
					<!-- DataTales Example -->
                    <div class="card shadow mb-4">
                    
                        <div class="card-header py-3 input-group">
                       <!-- Topbar Search -->
		                    <form action="xacnhanAdminController" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
		                        <div class="input-group">
		                            <input type="text" name="timKhachHang" class="form-control bg-light border-1 small" placeholder="Nhập khách hàng cần tìm kiếm"
		                                aria-label="Search" aria-describedby="basic-addon2" style="width:300px">
		                            <div class="input-group-append">
		                                <button class="btn btn-primary" type="submit">
		                                    <i class="fas fa-search fa-sm"></i>
		                                </button>
		                            </div>
		                        </div>
		                    </form>  
                        </div>
                        
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                        	<th>Tên khách hàng</th>
                                            <th>Tên sách</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th>Ngày mua</th>
											<th>Thành tiền</th>
											<th>Đã mua</th>
                                            <th width="150px"></th>
                                        </tr>
                                    </thead>
                                    <% ArrayList<xacnhan> dsdonhang = (ArrayList<xacnhan>) request.getAttribute("dsdonhang");
                                    for(xacnhan s: dsdonhang){
                                    %>
                                    <tbody>
                                        <tr>
                                            <td><%=s.getHoten() %></td>
                                            <td><%=s.getTenSach() %> </td>
                                            <td><%=s.getSoLuongMua() %></td>
                                            <td><%=String.format("%,d VND", (int) s.getGia()) %></td>
                                            <td><%=s.getNgayMuaFormat() %></td>
                                            <td><%=String.format("%,d VND", (int) s.getThanhTien())%></td>
                                            <td><%=s.isDaMua() ? "Đã thanh toán" : "Chưa thanh toán" %></td>
											<td class="text-center">
											<%if(!s.isDaMua()){ %>
											    <a href="xacnhanChiTietController?mactdh=<%= s.getMacthd() %>"
											    onclick="return confirm('Bạn có chắc chắn muốn xác nhận đơn hàng này không?');" 
											       class="btn btn-xs btn-info">
											       Xác nhận
											    </a>
											    <%} %>
											</td>
										</tr>
                                        
                                        </tbody>                                   
                                        <%} %>
                                  <% String message = (String) request.getAttribute("Message");
								           if (message != null) { %>
								            <div class="alert alert-success" role="alert">
								                <%= message %>
								            </div>
								        <% } %>
                                </table>
              <!-- Phân trang -->
	<div class="row mt-3 d-flex justify-content-center">
    <nav aria-label="Page navigation example" class="text-center">
        <ul class="pagination justify-content-center">
            <%
            int totalPages = (Integer) request.getAttribute("totalPages"); // tổng số trang
            int currentPage = (Integer) request.getAttribute("currentPage"); // trang hiện tại
            int maxDisplay = 20; // Giới hạn số trang tối đa hiển thị

            // Nút "Trước"
            if (currentPage > 1) {
            %>
            <li class="page-item">
                <a class="page-link" href="?page=<%= currentPage - 1 %>" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
            } else {
            %>
            <li class="page-item disabled">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <%
            }

            // Hiển thị rút gọn nếu số trang lớn hơn maxDisplay
            if (totalPages > maxDisplay) {
                // Hiển thị các trang đầu tiên
                for (int i = 1; i <= 2; i++) {
                    if (i == currentPage) {
            %>
            <li class="page-item active"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    } else {
            %>
            <li class="page-item"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    }
                }

                // Hiển thị "..." nếu cần
                if (currentPage > 5) {
            %>
            <li class="page-item disabled"><a class="page-link" href="#">...</a></li>
            <%
                }

                // Hiển thị trang gần hiện tại
                for (int i = Math.max(3, currentPage - 2); i <= Math.min(totalPages - 2, currentPage + 2); i++) {
                    if (i == currentPage) {
            %>
            <li class="page-item active"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    } else {
            %>
            <li class="page-item"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    }
                }

                // Hiển thị "..." nếu cần
                if (currentPage < totalPages - 4) {
            %>
            <li class="page-item disabled"><a class="page-link" href="#">...</a></li>
            <%
                }

                // Hiển thị hai trang cuối
                for (int i = totalPages - 1; i <= totalPages; i++) {
                    if (i == currentPage) {
            %>
            <li class="page-item active"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    } else {
            %>
            <li class="page-item"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    }
                }

            } else {
                // Hiển thị tất cả các trang nếu totalPages <= maxDisplay
                for (int i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
            %>
            <li class="page-item active"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    } else {
            %>
            <li class="page-item"><a class="page-link" href="?page=<%= i %>"><%= i %></a></li>
            <%
                    }
                }
            }

            // Nút "Tiếp"
            if (currentPage < totalPages) {
            %>
            <li class="page-item">
                <a class="page-link" href="?page=<%= currentPage + 1 %>" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <%
            } else {
            %>
            <li class="page-item disabled">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <%
            }
            %>
        </ul>
    </nav>
</div>
              
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