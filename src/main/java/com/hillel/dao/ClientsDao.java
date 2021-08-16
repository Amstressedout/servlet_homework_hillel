package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Clients;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientsDao {
    private static final String FIND_ALL_CLIENTS = "SELECT * FROM clients";

    public List<Clients> findAllClients () {

        List<Clients> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_CLIENTS) ) {

            while (resultSet.next()) {
                Clients clients = new Clients();
                clients.setId(resultSet.getInt("id"));
                clients.setName(resultSet.getString("name"));
                clients.setEmail(resultSet.getString("email"));
                clients.setPhone(resultSet.getLong("phone"));
                clients.setAbout(resultSet.getString("about"));
                clients.setAge(resultSet.getInt("age"));
                resultList.add(clients);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }
}
