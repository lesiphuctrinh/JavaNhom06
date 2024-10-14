<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bảng cửu chương</title>
</head>
<body>

	<h2>Nhập vào số nguyên để hiển thị bảng cửu chương</h2>
	<form action="bai2.jsp" method="get">
	    <label for="number">Nhập số:</label> <br>
	    <input type="number" name="number" required> <br><br>
	    <input type="submit" value="Hiển thị">
	</form>

	<%
    // Lấy tham số từ người dùng nếu có
    String numberParam = request.getParameter("number");

    if (numberParam != null) {
        try {
            // Chuyển đổi chuỗi thành số nguyên
            int n = Integer.parseInt(numberParam);

            // Hiển thị bảng cửu chương của số n
            out.println("<h3>Bảng cửu chương của " + n + ":</h3>");
            out.println("<ul>");
            for (int i = 1; i <= 10; i++) {
                out.println("<li>" + n + " x " + i + " = " + (n * i) + "</li>");
            }
            out.println("</ul>");
        } catch (NumberFormatException e) {
            // Xử lý khi nhập không phải số
            out.println("<p style='color:red;'>Vui lòng nhập một số hợp lệ.</p>");
        }
    }
%>

</body>
</html>