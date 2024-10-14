<%@page import="giohangModal.giohangbo"%>
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
	giohangbo gh = (giohangbo) session.getAttribute("gh");
	String[] gtck = request.getParameterValues("ck");
	if (request.getParameter("xoachon") != null) {//Can xoa cac sach da chon
		for (String ms : gtck)
			gh.xoa(ms);
	}
	
	String xoamot = request.getParameter("msxoa"); // xoa mot sach
	if(xoamot != null){
		gh.xoa(xoamot);
	}
	
	String mssua = request.getParameter("butsuasl");
	String slsua = request.getParameter(mssua);
	if (mssua != null) {//Can sua sl
		gh.Them(mssua, "", (long) 0, Long.parseLong(slsua));
	}
	session.setAttribute("gh", gh);
	response.sendRedirect("htgio.jsp");
	%>
</body>
</html>