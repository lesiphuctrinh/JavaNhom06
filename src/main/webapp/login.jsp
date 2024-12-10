<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đăng nhập</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
    body {
        background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
        background-size: 400% 400%;
        animation: gradientBG 15s ease infinite;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
    }

    @keyframes gradientBG {
        0% { background-position: 0% 50%; }
        50% { background-position: 100% 50%; }
        100% { background-position: 0% 50%; }
    }

    .modal-content {
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    .modal-title {
        color: #333;
        font-weight: bold;
        text-align: center;
        margin-bottom: 10px;
    }

    .form-control {
        border-radius: 4px;
    }

    .btn-primary {
        background-color: #4b6cb7;
        border-color: #4b6cb7;
    }

    .btn-primary:hover {
        background-color: #3a5da1;
        border-color: #3a5da1;
    }

    .text-center a {
        color: #4b6cb7;
    }

    .text-center a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>

<div class="container d-flex align-items-center justify-content-center" style="height: 100vh;">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">ĐĂNG NHẬP</h2>
            </div>
            <div class="modal-body">
                <form action="loginController" method="post">
                    <div class="form-group">
                        <label for="dangnhap">Tên đăng nhập:</label>
                        <input type="text" class="form-control" name="dangnhap" placeholder="Mã đăng nhập" required>
                    </div>
                    <div class="form-group">
                        <label for="matkhau">Mật khẩu:</label>
                        <input type="password" class="form-control" name="matkhau" placeholder="Mật khẩu" required>
                    </div>
                    <%
                    if(session.getAttribute("dem") != null){
                    	int dem = (int) session.getAttribute("dem");
                    	if(dem >= 3){
                    	%>
                    	<img src="simpleCaptcha.jpg"/>
                        <input type="text" name="answer"/>
                  <%} 
                    	}%>
                    <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
                    <!-- Thông báo đăng ký -->
                    <div class="text-center" style="margin-top: 15px;">
                        <p>Bạn chưa có tài khoản? <a href="signupController">Đăng ký</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
