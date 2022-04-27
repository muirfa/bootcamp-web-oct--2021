/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class JdbcConnection {
    private Connection connection;

    public Connection createConnection() {
        try {
//            1. load jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");

//            2. create connection from connection string also provide username and password
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp", "root", "1tsUP.SHteam");
            }
            return connection;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
