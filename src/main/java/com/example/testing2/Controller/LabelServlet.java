package com.example.testing2.Controller;

import com.example.testing2.Model.Label;
import com.example.testing2.Model.Song;
import com.example.testing2.Service.LabelDAO;
import com.example.testing2.Service.SongDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/song")
public class LabelServlet extends HttpServlet {
    private SongDAO songDAO;
    private LabelDAO labelDAO;

    public void init() {
        // Khởi tạo các đối tượng DAO
        try {
            songDAO = new SongDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            labelDAO = new LabelDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Song> danhSachBaiHat = songDAO.getAllSongs();
        List<Label> danhSachNhans = labelDAO.getAllLabels();
        request.setAttribute("danhSachBaiHat", danhSachBaiHat);
        request.setAttribute("danhSachNhans", danhSachNhans);
        RequestDispatcher dispatcher = request.getRequestDispatcher("label.jsp");
        dispatcher.forward(request, response);
    }
}
