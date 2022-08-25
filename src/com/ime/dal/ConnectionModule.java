package com.ime.dal;

import java.sql.*;

public class ConnectionModule {
    //method to establish the connection with the DB
    public static Connection connector() {
        java.sql.Connection connection = null;
        //driver to calls db driver
        String driver = "com.mysql.cj.jdbc.Driver";
        // var to store info of db
        String url = "jdbc:mysql://localhost:3306/airportlist";
        String user = "root";
        String password = "123456";
        //establish connection with db
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (Exception e) {
            //Impressão do erro
            System.out.println(e);
            return null;
        }
    }
}