<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách mặt bằng</title>
</head>
<body>

<h2>Danh sách mặt bằng</h2>

<!-- SEARCH -->
<form method="get" action="/matbang">
    <input type="hidden" name="action" value="search"/>

    Loại:
    <select name="loai">
        <option value="">--All--</option>
        <option>Văn phòng chia sẻ</option>
        <option>Văn phòng trọn gói</option>
    </select>

    Tầng:
    <input type="number" name="tang"/>

    Giá <=
    <input type="number" name="gia"/>

    <button type="submit">Tìm kiếm</button>
</form>

<br>

<a href="/matbang?action=create">+ Thêm mới</a>

<br><br>

<table border="1" cellpadding="8">
    <tr>
        <th>Mã</th>
        <th>Diện tích</th>
        <th>Trạng thái</th>
        <th>Tầng</th>
        <th>Loại</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>

    <c:forEach var="mb" items="${list}">
        <tr>
            <td>${mb.maMatBang}</td>
            <td>${mb.dienTich}</td>
            <td>${mb.trangThai}</td>
            <td>${mb.tang}</td>
            <td>${mb.loaiVanPhong}</td>
            <td>${mb.gia}</td>
            <td>
                <a href="/matbang?action=delete&id=${mb.id}"
                   onclick="return confirm('Bạn có chắc muốn xóa ${mb.maMatBang}?')">
                    Xóa
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>