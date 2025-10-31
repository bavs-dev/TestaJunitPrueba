package com.example.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";  // Conexión con Oracle
    private static final String USER = "SYSTEM";
    private static final String PASS = "admin";

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error en la conexión con la base de datos", e);
        }
    }
}
