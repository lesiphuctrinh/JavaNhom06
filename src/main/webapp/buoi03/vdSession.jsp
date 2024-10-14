<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	// kiểm tra đã tạo session chưa
		if(session.getAttribute("tong") == null){ // chưa tạo
			session.setAttribute("tong", (int)0); // đã tạo
		}
		
		String a = request.getParameter("txtn");
		if(a != null){
			int b = Integer.parseInt(a);
			//b1: gán session vào 1 biến
			int sum = (int)session.getAttribute("tong");
			//b2: thay đổi giá trị của biến
			sum+=b;
			//b3: gán biến vào session
			session.setAttribute("tong", sum);
			out.print(session.getAttribute("tong"));
	
		}
	%>
	<form action="vdSession.jsp" method="post">
		n = <input type="number" name="txtn" value="0"> <br>
		<input type="submit" name="but1" value="Tong">
	</form>
</body>
</html>