package com.example.final_example_module3.dao;

import com.example.final_example_module3.model.MatBang;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class MatBangDAO {

    public static final String INSERT_INTO_MATBANG = "INSERT INTO mat_bang(ma_mat_bang, dien_tich, trang_thai, tang, loai_van_phong, mo_ta, gia, ngay_bat_dau, ngay_ket_thuc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM mat_bang ORDER BY dien_tich ASC";
    public static final String SELECT_MA_MAT_BANG = "SELECT * FROM mat_bang WHERE ma_mat_bang = ?";
    public static final String DELETE_BY_ID = "DELETE FROM mat_bang WHERE id = ?";

    public void insert(MatBang mb) throws SQLException {

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement ps = conn.prepareStatement(INSERT_INTO_MATBANG)) {

                ps.setString(1, mb.getMaMatBang());
                ps.setDouble(2, mb.getDienTich());
                ps.setString(3, mb.getTrangThai());
                ps.setInt(4, mb.getTang());
                ps.setString(5, mb.getLoaiVanPhong());
                ps.setString(6, mb.getMoTa());
                ps.setDouble(7, mb.getGia());
                ps.setDate(8, new java.sql.Date(mb.getNgayBatDau().getTime()));
                ps.setDate(9, new java.sql.Date(mb.getNgayKetThuc().getTime()));

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<MatBang> findAll() throws SQLException {
        List<MatBang> list = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
        ) {
            assert conn != null;
            try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL);) {

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    MatBang mb = new MatBang();

                    mb.setId(rs.getInt("id"));
                    mb.setMaMatBang(rs.getString("ma_mat_bang"));
                    mb.setDienTich(rs.getDouble("dien_tich"));
                    mb.setTrangThai(rs.getString("trang_thai"));
                    mb.setTang(rs.getInt("tang"));
                    mb.setLoaiVanPhong(rs.getString("loai_van_phong"));
                    mb.setMoTa(rs.getString("mo_ta"));
                    mb.setGia(rs.getDouble("gia"));
                    mb.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                    mb.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));

                    list.add(mb);
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }

        return list;
    }

    public boolean existsByMaMatBang(String ma) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_MA_MAT_BANG)) {

            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public void delete(int id) throws SQLException {
        try(Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try(PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID)){
                ps.setInt(1, id);
                ps.executeUpdate();
            }
        }
    }

    public List<MatBang> search(String loai, Integer tang, Double gia) throws SQLException {
        List<MatBang> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM mat_bang WHERE 1=1");

        if (loai != null && !loai.isEmpty()) {
            sql.append(" AND loai_van_phong = ?");
        }
        if (tang != null) {
            sql.append(" AND tang = ?");
        }
        if (gia != null) {
            sql.append(" AND gia <= ?");
        }

        sql.append(" ORDER BY dien_tich ASC");

        try (Connection conn = DBConnection.getConnection()) {
            assert conn != null;
            try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {

                int index = 1;

                if (loai != null && !loai.isEmpty()) {
                    ps.setString(index++, loai);
                }
                if (tang != null) {
                    ps.setInt(index++, tang);
                }
                if (gia != null) {
                    ps.setDouble(index++, gia);
                }

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    MatBang mb = new MatBang();

                    mb.setId(rs.getInt("id"));
                    mb.setMaMatBang(rs.getString("ma_mat_bang"));
                    mb.setDienTich(rs.getDouble("dien_tich"));
                    mb.setTrangThai(rs.getString("trang_thai"));
                    mb.setTang(rs.getInt("tang"));
                    mb.setLoaiVanPhong(rs.getString("loai_van_phong"));
                    mb.setMoTa(rs.getString("mo_ta"));
                    mb.setGia(rs.getDouble("gia"));
                    mb.setNgayBatDau(rs.getDate("ngay_bat_dau"));
                    mb.setNgayKetThuc(rs.getDate("ngay_ket_thuc"));

                    list.add(mb);
                }
            }
        }

        return list;
    }
}
