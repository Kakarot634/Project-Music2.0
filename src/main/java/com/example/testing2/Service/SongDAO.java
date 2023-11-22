package com.example.testing2.Service;

import com.example.testing2.Model.Label;
import com.example.testing2.Model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class SongDAO{
    private Connection connection;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/WebMusic";
    private static final String USER = "root";
    private static final String PASS = "07122004";

    public SongDAO() throws SQLException {
        connection = getConnection(DB_URL, USER, PASS);
    }
    public List<Song> getAllSongs() {
        List<Song> listSongs = new ArrayList<>();

        try {
            String query = "SELECT * FROM Song";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song();
                song.setId(resultSet.getInt("id"));
                song.setName(resultSet.getString("name"));
                List<Label> listLabels = getListLabelOfSongs(song.getId());
                song.setLabels(listLabels);

                listSongs.add(song);
            }
            String sql = "SELECT * FROM song";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Song song = new Song();
                song.setId(rs.getInt("id"));
                song.setName(rs.getString("name"));

                listSongs.add(song);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listSongs;
    }
    public List<Label> getListLabelOfSongs(int baiHatId) {
        List<Label> listLabels = new ArrayList<>();

        try {
            String query = "SELECT nhan.* FROM nhan_bai_hat " +
                    "JOIN nhan ON nhan_bai_hat.nhan_id = nhan.id " +
                    "WHERE nhan_bai_hat.bai_hat_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, baiHatId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Label label = new Label();
                label.setId(resultSet.getInt("id"));
                label.setName(resultSet.getString("ten"));

                listLabels.add(label);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listLabels;
    }
}
