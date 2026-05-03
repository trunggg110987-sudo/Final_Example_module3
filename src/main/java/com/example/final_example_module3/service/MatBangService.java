package com.example.final_example_module3.service;

import com.example.final_example_module3.dao.MatBangDAO;
import com.example.final_example_module3.model.MatBang;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatBangService {

    private MatBangDAO dao = new MatBangDAO();

    public List<MatBang> findAll() throws Exception {
        return dao.findAll();
    }

    public void delete(int id) throws Exception {
        dao.delete(id);
    }

    public List<MatBang> search(String loai, Integer tang, Double gia) throws Exception {
        return dao.search(loai, tang, gia);
    }

    public List<String> createFromRequest(HttpServletRequest req) throws Exception {
        List<String> errors = new ArrayList<>();

        String ma = req.getParameter("ma");
        double dienTich = Double.parseDouble(req.getParameter("dienTich"));
        double gia = Double.parseDouble(req.getParameter("gia"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(req.getParameter("ngayBatDau"));
        Date end = sdf.parse(req.getParameter("ngayKetThuc"));

        if (dao.existsByMaMatBang(ma)) {
            errors.add("Mã đã tồn tại");
        }

        if (dienTich <= 20) {
            errors.add("Diện tích > 20");
        }

        if (gia <= 1000000) {
            errors.add("Giá > 1tr");
        }

        long months = (end.getTime() - start.getTime()) / (1000L * 60 * 60 * 24 * 30);
        if (months < 6) {
            errors.add(">= 6 tháng");
        }

        if (!errors.isEmpty()) return errors;

        MatBang mb = new MatBang();
        mb.setMaMatBang(ma);
        mb.setDienTich(dienTich);
        mb.setTrangThai(req.getParameter("trangThai"));
        mb.setTang(Integer.parseInt(req.getParameter("tang")));
        mb.setLoaiVanPhong(req.getParameter("loai"));
        mb.setMoTa(req.getParameter("moTa"));
        mb.setGia(gia);
        mb.setNgayBatDau(start);
        mb.setNgayKetThuc(end);

        dao.insert(mb);

        return errors;
    }
}
