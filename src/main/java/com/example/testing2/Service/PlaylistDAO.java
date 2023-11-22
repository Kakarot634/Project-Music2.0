package com.example.testing2.Service;

import com.example.testing2.Model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/WebMusic";
    private static final String USER = "root";
    private static final String PASS = "07122004";

    public List<Playlist> getNewPlaylists(int limit){
        List<Playlist> resultList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT * FROM Playlist";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                resultSet.getInt("Id");
                resultSet.getString("name");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return resultList;
    }
}
