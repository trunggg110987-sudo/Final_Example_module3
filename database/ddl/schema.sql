create database tcomplex;
use database tcomplex;
DROP TABLE IF EXISTS `mat_bang`;

CREATE TABLE `mat_bang` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `ma_mat_bang` varchar(20) DEFAULT NULL,
                            `dien_tich` double DEFAULT NULL,
                            `trang_thai` varchar(50) DEFAULT NULL,
                            `tang` int DEFAULT NULL,
                            `loai_van_phong` varchar(50) DEFAULT NULL,
                            `mo_ta` text,
                            `gia` double DEFAULT NULL,
                            `ngay_bat_dau` date DEFAULT NULL,
                            `ngay_ket_thuc` date DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ma_mat_bang` (`ma_mat_bang`)
)
INSERT INTO `mat_bang` VALUES (3,'222-11-56',200,'Äáº§y Äá»§',1,'VÄn phÃ²ng trá»n gÃ³i','khÃ´ng mÃ´ táº£',2000000000000,'2011-02-02','2026-04-29'),(4,'111-99-88',200,'Trá»ng',1,'VÄn phÃ²ng trá»n gÃ³i','khÃ´ng cÃ³ mÃ´ táº£ ',12800000000000,'2009-05-24','2026-04-29'),(5,'483-11-44',1990,'Trá»ng',1,'VÄn phÃ²ng trá»n gÃ³i','khÃ´ng cÃ³ mÃ´ táº£ ',20000000,'2013-04-14','2026-04-29'),(6,'949-99-57',5000,'Trá»ng',10,'VÄn phÃ²ng chia sáº»','khÃ´ng cÃ³ mÃ´ táº£ ',8189000000000,'2024-03-24','2026-04-29');

