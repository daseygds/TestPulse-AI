package org.testngmetadatalibs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.testngmetadatalibs.utils.ConfigLoader.getDBConfigProp;

public class DatabaseConnection {

    private static volatile Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection(
                                getDBConfigProp()[0],
                                getDBConfigProp()[1],
                                getDBConfigProp()[2]
                        );
                    } catch (SQLException e) {
                        throw new RuntimeException("Failed to establish DB connection", e);
                    }
                }
            }
        }
        return connection;
    }
}
