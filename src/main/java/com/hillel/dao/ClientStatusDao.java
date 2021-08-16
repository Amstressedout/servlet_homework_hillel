package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.ClientStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusDao {
    private static final String FiND_ALL_FROM_CLIENTSTATUS = "SELECT * FROM client_status";

    public List<ClientStatus> findAllFromClientStatus() {

        List<ClientStatus> resultList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FiND_ALL_FROM_CLIENTSTATUS) ) {

            while (resultSet.next()) {
                ClientStatus clientStatus = new ClientStatus();
                clientStatus.setClientId(resultSet.getInt("client_id"));
                clientStatus.setStatusId(resultSet.getInt("status_id"));
                resultList.add(clientStatus);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return resultList;
    }
}
