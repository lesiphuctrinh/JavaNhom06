<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xổ Số</title>
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
            xhr.open("GET", "Xoso.jsp?day=" + day + "&month=" + month + "&year=" + year + "&ajax=true", true);
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

    <form onsubmit="return false;">
        <label for="day">Chọn ngày:</label>
        <select name="day" id="day">
            <% 
                for (int i = 1; i <= 31; i++) {
                    out.print("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>

        <label for="month">Chọn tháng:</label>
        <select name="month" id="month">
            <% 
                for (int i = 1; i <= 12; i++) {
                    out.print("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>

        <label for="year">Chọn năm:</label>
        <select name="year" id="year">
            <% 
                int currentYear = 2024;
                for (int i = currentYear - 10; i <= currentYear; i++) {
                    out.print("<option value='" + i + "'>" + i + "</option>");
                }
            %>
        </select>
		<br>
        <button type="button" onclick="getLotteryResult()">Kết Quả</button>
    </form>

    <div id="result">
        <% 
            String ajax = request.getParameter("ajax");
            if (ajax != null && ajax.equals("true")) {
                String day = request.getParameter("day");
                String month = request.getParameter("month");
                String year = request.getParameter("year");

                if (day != null && month != null && year != null) {
                    java.util.Random rand = new java.util.Random();
                    int randomNumber = rand.nextInt(1000000); 
                    String formattedNumber = String.format("%06d", randomNumber);

                    // Hiển thị kết quả
                    out.println("<h2>Kết quả xổ số cho ngày: " + day + "/" + month + "/" + year + "</h2>");
                    out.println("<p>Kết quả : " + formattedNumber + "</p>");
                }
            }
        %>
    </div>

</body>
</html>