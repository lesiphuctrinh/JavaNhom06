<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả xổ số kiến thiết</title>
    <script>
        function updateTime() {
            var now = new Date();
            
            
            var year = now.getFullYear();
            var month = now.getMonth() + 1; 
            var day = now.getDate();
      
            var hours = now.getHours();
            var minutes = now.getMinutes();
            var seconds = now.getSeconds();
            var ampm = hours >= 12 ? 'PM' : 'AM';
            
            hours = hours % 12;
            hours = hours ? hours : 12; 
            minutes = minutes < 10 ? '0' + minutes : minutes;
            seconds = seconds < 10 ? '0' + seconds : seconds;
            
            var dateString = year + '-' + (month < 10 ? '0' + month : month) + '-' + (day < 10 ? '0' + day : day);
            var timeString = hours + ':' + minutes + ':' + seconds + ' ' + ampm;
            
            document.getElementById('currentDate').innerText = dateString + ' ' + timeString;
        }
        
        setInterval(updateTime, 1000);
        window.onload = updateTime;

        function getLotteryResult() {
            const day = document.getElementById("day").value;
            const month = document.getElementById("month").value;
            const year = document.getElementById("year").value;
 
            const xhr = new XMLHttpRequest();
            xhr.open("GET", "bai3_kqxs.jsp?day=" + day + "&month=" + month + "&year=" + year + "&ajax=true", true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var parser = new DOMParser();
                    var doc = parser.parseFromString(xhr.responseText, "text/html");
                    var result = doc.getElementById("result").innerHTML;
                    
                    document.getElementById("result").innerHTML = result;
                }
            };

            xhr.send();
        }
    </script>
</head>
<body>
 	<h1>Trang Kết Quả Xổ Số</h1>
	<p>Hôm nay: <span id="currentDate"></span></p>
    <h2>Chọn ngày tháng năm:</h2>
    <form action="bai3_kqxs.jsp" method="post">
        Ngày: 
        <select name="day">
            <%
                for (int i = 1; i <= 31; i++) {
                    out.println("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>
        
        Tháng: 
        <select name="month">
            <%
                for (int i = 1; i <= 12; i++) {
                    out.println("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>

        Năm: 
        <select name="year">
            <%
                for (int i = 2000; i <= 2024; i++) {
                    out.println("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>

        <br><br>
        <input type="submit" value="Xem kết quả">
    </form>

</body>
</html>