package com.example.final_example_module3.controller;

import com.example.final_example_module3.service.MatBangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.io.IOException;


@WebServlet(name = "MatBangServlet", value = "/matbang")
public class MatBangServlet extends HttpServlet {

    private MatBangService service;

    @Override
    public void init() {
        service = new MatBangService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (action == null) action = "";

        try {
            switch (action) {
                case "create":
                    showCreate(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                case "search":
                    search(req, resp);
                    break;
                default:
                    list(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if (action == null) action = "";

        try {
            if (action.equals("create")) {
                create(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("list", service.findAll());
        req.getRequestDispatcher("view/list.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("view/create.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("matbang");
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String loai = req.getParameter("loai");
        String tangStr = req.getParameter("tang");
        String giaStr = req.getParameter("gia");

        Integer tang = (tangStr == null || tangStr.isEmpty()) ? null : Integer.parseInt(tangStr);
        Double gia = (giaStr == null || giaStr.isEmpty()) ? null : Double.parseDouble(giaStr);

        req.setAttribute("list", service.search(loai, tang, gia));
        req.getRequestDispatcher("view/list.jsp").forward(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<String> errors = service.createFromRequest(req);

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("view/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("matbang");
        }
    }
}