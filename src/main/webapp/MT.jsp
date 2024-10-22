<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	int kq=0, a=0, b=0;
		String tama = request.getParameter("txta");
		String tamb = request.getParameter("txtb");
		if(tama != null && tamb != null){
			a = Integer.parseInt(tama);
			b = Integer.parseInt(tamb);
			if(request.getParameter("butcong") != null){
				kq = a + b;
			}
			else if(request.getParameter("buttru") != null){
				kq = a - b;
			}
			else if(request.getParameter("butnhan") != null){
				kq = a * b;
			}
			else if(request.getParameter("butchia") != null){
				kq = a / b;
			}
		}
	
	%>
	<form action="MT.jsp" method="post">
		a = <input type="number" name="txta" value="<%=a%>"> <br>
		b = <input type="number" name="txtb" value="<%=b%>"> <br>
		kq = <input type="number" name="txtkq" value="<%=kq%>"> <br>
		<input type="submit" name="butcong" value="+">
		<input type="submit" name="buttru" value="-">
		<input type="submit" name="butnhan" value="*">
		<input type="submit" name="butchia" value="/">
	</form>
</body>
</html>