# 🏢 TComplex - Quản lý mặt bằng cho thuê

## 📌 Giới thiệu

Dự án Java Web sử dụng **JSP/Servlet + JDBC + MySQL** để quản lý thông tin mặt bằng cho thuê tại tòa nhà TComplex (Đà Nẵng).

---

## 🚀 Chức năng chính

### 1. Thêm mới mặt bằng

* Nhập đầy đủ thông tin:

    * Mã mặt bằng (định dạng `XXX-XX-XX`)
    * Diện tích (> 20m²)
    * Trạng thái (Trống / Hạ tầng / Đầy đủ)
    * Tầng (1–15)
    * Loại (Văn phòng chia sẻ / trọn gói)
    * Giá (> 1.000.000 VNĐ)
    * Ngày bắt đầu – kết thúc (dd/MM/yyyy)

### 2. Hiển thị danh sách

* Hiển thị toàn bộ mặt bằng
* Sắp xếp tăng dần theo diện tích

### 3. Tìm kiếm

* Theo:

    * Loại mặt bằng
    * Tầng
    * Giá
* Có thể kết hợp nhiều điều kiện

### 4. Xóa mặt bằng

* Có xác nhận trước khi xóa

---

## 🧱 Công nghệ sử dụng

* Java Servlet / JSP
* JDBC
* MySQL
* JSTL
* Apache Tomcat

---

## 📂 Cấu trúc thư mục

```
src/
 └── com.example.final_example_module3
      ├── controller
      ├── service
      ├── dao
      └── model

web/
 ├── view/
 │    ├── list.jsp
 │    └── create.jsp
 └── WEB-INF/
      └── web.xml
```

---

## ⚙️ Cài đặt & chạy project

### 1. Clone project

```bash
git clone <your-repo-url>
```

### 2. Cấu hình database

```sql
CREATE DATABASE tcomplex;
```

### 3. Tạo bảng

```sql
CREATE TABLE mat_bang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ma_mat_bang VARCHAR(20) UNIQUE,
    dien_tich DOUBLE,
    trang_thai VARCHAR(50),
    tang INT,
    loai_van_phong VARCHAR(50),
    mo_ta TEXT,
    gia DOUBLE,
    ngay_bat_dau DATE,
    ngay_ket_thuc DATE
);
```

### 4. Cấu hình DBConnection

```java
jdbc:mysql://localhost:3306/tcomplex?useUnicode=true&characterEncoding=UTF-8
```

### 5. Chạy project

* Deploy lên Tomcat
* Truy cập:

```
http://localhost:8080/matbang
```

---

## ⚠️ Lưu ý

* Phải sử dụng UTF-8 để tránh lỗi font tiếng Việt
* Nếu dữ liệu hiển thị sai → xóa và insert lại
* Đảm bảo đã thêm MySQL Connector

---

## 🎯 Kết quả đạt được

* CRUD hoàn chỉnh
* Validate đầy đủ client + server
* Code theo mô hình MVC
* Giao diện rõ ràng, dễ sử dụng

---

## 👨‍💻 Tác giả

* Student: [Your Name]
* Module: Java Web Backend Development

---
