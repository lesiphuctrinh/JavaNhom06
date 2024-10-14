<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Bảng cửu chương</h1>
	<table class="table table-bordered table-hover">
			<%for (int i=1; i<=10; i++){ %>
			<tr>
				<%for(int j=1; j<10; j++){ %>
					<td><%=j%>x<%=i%> = <%=i*j %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
</body>
</html>