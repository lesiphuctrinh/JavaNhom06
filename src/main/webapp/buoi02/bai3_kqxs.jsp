<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả xổ số kiến thiết</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Căn giữa toàn bộ nội dung theo chiều dọc */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
        }
    </style>
</head>
<body>

<%
    String day = request.getParameter("day");
    String month = request.getParameter("month");
    String year = request.getParameter("year");

    // Dữ liệu kết quả xổ số
    String giaiDacBiet = "813119";
    String giaiNhat = "59659";
    String giaiNhi = "60956";
    String[] giaiBa = {"56052", "43217"};
    String[] giaiTu = {"29976", "62737", "21441", "86995", "47463", "40670", "13591"};
    String giaiNam = "1928";
    String[] giaiSau = {"642", "071", "970", "930"};
    String giaiBay = "862";
    String giaiTam = "16";
%>

    <div class="container text-center">
        <h2 class="text-center mt-4">Kết quả xổ số ngày <%= day %> tháng <%= month %> năm <%= year %></h2>

        <table class="table table-bordered table-hover mx-auto mt-4">
            <thead class="thead-dark">
                <tr>
                    <th class="text-center">Giải</th>
                    <th class="text-center">Kết quả</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">Giải Đặc Biệt</td>
                    <td class="text-center"><%= giaiDacBiet %></td>
                </tr>
                <tr>
                    <td class="text-center">Giải Nhất</td>
                    <td class="text-center"><%= giaiNhat %></td>
                </tr>
                <tr>
                    <td class="text-center">Giải Nhì</td>
                    <td class="text-center"><%= giaiNhi %></td>
                </tr>
                <tr>
                    <td class="text-center">Giải Ba</td>
                    <td class="text-center">
                        <%
                            for (int i = 0; i < giaiBa.length; i++) {
                                out.print(giaiBa[i]);
                                if (i < giaiBa.length - 1) {
                                    out.print(", ");
                                }
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Giải Tư</td>
                    <td class="text-center">
                        <%
                            for (int i = 0; i < giaiTu.length; i++) {
                                out.print(giaiTu[i]);
                                if (i < giaiTu.length - 1) {
                                    out.print(", ");
                                }
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Giải Năm</td>
                    <td class="text-center"><%= giaiNam %></td>
                </tr>
                <tr>
                    <td class="text-center">Giải Sáu</td>
                    <td class="text-center">
                        <%
                            for (int i = 0; i < giaiSau.length; i++) {
                                out.print(giaiSau[i]);
                                if (i < giaiSau.length - 1) {
                                    out.print(", ");
                                }
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <td class="text-center">Giải Bảy</td>
                    <td class="text-center"><%= giaiBay %></td>
                </tr>
                <tr>
                    <td class="text-center">Giải Tám</td>
                    <td class="text-center"><%= giaiTam %></td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
