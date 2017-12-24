/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasha.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javatarr
 */
public class DatabaseFactory {
    private final String connectionURL = "jdbc:mysql://localhost:3306/world";
    private final String dbUser        = "root";
    private final String dbPass        = "Abrams@1994";
    
    private static DatabaseFactory connection;
    
    private DatabaseFactory(){}
    
    // lazy initialization
    public static DatabaseFactory getInstance(){
        if(connection == null) return new DatabaseFactory();
        else                   return connection; 
    }
    
    // get connection
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(connectionURL, dbUser, dbPass);
        return conn;
    }
}
