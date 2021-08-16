package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Statuses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StatusesDao {
    private static final String FIND_ALL_STATUSES = "SELECT * FROM statuses";

    public List<Statuses> findAllStatuses() {

        List<Statuses> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_STATUSES)) {

            while (resultSet.next()) {
                Statuses statuses = new Statuses();
                statuses.setId(resultSet.getInt("id"));
                statuses.setAlias(resultSet.getString("alias"));
                statuses.setDescription(resultSet.getString("description"));
                resultList.add(statuses);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
