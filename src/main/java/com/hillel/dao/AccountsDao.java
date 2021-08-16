package com.hillel.dao;

import com.hillel.database.Database;
import com.hillel.entity.Accounts;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountsDao {
    private static final String FIND_ALL_ACCOUNTS = "SELECT * FROM accounts";

    public List<Accounts> findAllAccounts() {

        List<Accounts> resultList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL_ACCOUNTS)) {

            while (resultSet.next()) {
                Accounts accounts = new Accounts();
                accounts.setId(resultSet.getInt("id"));
                accounts.setClientId(resultSet.getInt("clientId"));
                accounts.setNumber(resultSet.getString("number"));
                accounts.setValue(resultSet.getDouble("value"));
                resultList.add(accounts);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return resultList;
    }
}
