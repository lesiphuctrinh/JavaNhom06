<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String tama = request.getParameter("txta");
	String tamb = request.getParameter("txtb");
	
	if(tama != null && tamb != null){
		int a = Integer.parseInt(tama);
		int b = Integer.parseInt(tamb);
		
		int kq = 0;
		if(request.getParameter("butcong") != null)
			kq = a+b;
		response.sendRedirect("MayTinh.jsp?kq=" + kq + "&a=" + a + "&b=" + b);
		
	}else{
		out.print("Vui lòng nhập a, b");
	}
	
	%>
</body>
</html>