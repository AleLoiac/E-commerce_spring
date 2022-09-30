package com.example.demo;

import java.sql.*;

public class ConnectionHandler {

    public static final String DB_URL = "jdbc:postgresql://localhost:5432";

    private final String connectionUrl;

    private Connection connection;

    public ConnectionHandler(String dbUrl, String dbName, String schema, String username, String password) throws ClassNotFoundException {
        this.connectionUrl = dbUrl + "/" + dbName
                + "?currentSchema=" + schema
                + "&user=" + username
                + "&password=" + password;

        Class.forName("org.postgresql.Driver");
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || this.connection.isClosed()) {
            this.connection = DriverManager.getConnection(connectionUrl);
        }
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (!(connection == null || this.connection.isClosed())) {
            this.connection.close();
            this.connection = null;
        }
    }

    public Statement getStatement() throws SQLException {
        connection = getConnection();
        return connection.createStatement();
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        // Uso il metodo getConnection invece di accedere direttamente per
        // garantire che la connection sia attiva
        Connection conn = getConnection();

        // Creo un oggetto PreparedStatement con la query specificata come parametro e lo ritorno
        return conn.prepareStatement(query);
    }
}
