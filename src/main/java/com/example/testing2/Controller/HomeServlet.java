package com.example.testing2.Controller;

import com.example.testing2.Model.Playlist;
import com.example.testing2.Service.PlaylistDAO;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HomeServlet extends HttpServlet {
    private PlaylistDAO playlistDAO;

    public void init() throws ServletException {
        super.init();
        playlistDAO = new PlaylistDAO() {
            public List<Playlist> getNewPlaylists(int limit) {
                return null;
            }
        };
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Playlist> newPlaylists = playlistDAO.getNewPlaylists(5);
        request.setAttribute("newPlaylists", newPlaylists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
        dispatcher.forward(request, response);
    }
}