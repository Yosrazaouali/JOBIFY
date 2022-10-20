/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aissa
 */
public class Mydb {

    private static Mydb instance;
    private Connection cnx;

    private final String URL = "jdbc:mysql://localhost:3306/pidev" ;
    private final String LOGIN = "root";
    private final String PASSWORD = "";

    public Mydb() {
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conncting !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Mydb getInstance() {
        if (instance == null) {
            instance = new Mydb();
        }
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
