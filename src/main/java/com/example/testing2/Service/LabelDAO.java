package com.example.testing2.Service;

import com.example.testing2.Model.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class LabelDAO {
    private Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/WebMusic";
    private static final String USER = "root";
    private static final String PASS = "07122004";

    public LabelDAO() throws SQLException {
        connection = getConnection(DB_URL, USER, PASS);
    }
    public List<Label> getAllLabels() {
        List<Label> listLabels = new ArrayList<>();
        try {
            String query = "SELECT * FROM nhan";
            PreparedStatement statement = connection.prepareStatement(query);
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
