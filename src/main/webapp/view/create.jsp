<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">

<h2>Thêm mới mặt bằng</h2>

<form method="post" action="matbang" onsubmit="return validateForm()">
    <input type="hidden" name="action" value="create"/>

    Mã:
    <input type="text" name="ma" id="ma" required><br><br>

    Diện tích:
    <input type="number" name="dienTich" required><br><br>

    Trạng thái:
    <select name="trangThai">
        <option>Trống</option>
        <option>Hạ tầng</option>
        <option>Đầy đủ</option>
    </select><br><br>

    Tầng:
    <select name="tang">
        <% for(int i=1;i<=15;i++){ %>
        <option value="<%=i%>"><%=i%></option>
        <% } %>
    </select><br><br>

    Loại:
    <select name="loai">
        <option>Văn phòng chia sẻ</option>
        <option>Văn phòng trọn gói</option>
    </select><br><br>

    Mô tả:
    <input type="text" name="moTa"><br><br>

    Giá:
    <input type="number" name="gia" required><br><br>

    Ngày bắt đầu:
    <input type="date" name="ngayBatDau" required><br><br>

    Ngày kết thúc:
    <input type="date" name="ngayKetThuc" required><br><br>

    <button type="submit">Lưu</button>
</form>

<c:if test="${not empty errors}">
    <ul>
        <c:forEach var="e" items="${errors}">
            <li style="color:red">${e}</li>
        </c:forEach>
    </ul>
</c:if>

<script>
    function validateForm() {
        let ma = document.getElementById("ma").value;
        let regex = /^[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}$/;

        if (!regex.test(ma)) {
            alert("Mã phải đúng định dạng XXX-XX-XX (chữ hoa hoặc số)");
            return false;
        }

        return true;
    }
</script>