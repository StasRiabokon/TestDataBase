/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yasta
 */
public class TestDB {

    public static void main(String[] args) throws ClassNotFoundException {
        
        try {
            runTest();
        } catch (SQLException e) {
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
    }

    public static void runTest() throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/dataBase", "stas", "stas")) {
            Statement stat = conn.createStatement();
            stat.executeUpdate("INSERT INTO STAS.FRIENDS VALUES(3, 'Bob', 'Fisher', 'Fish', '2000-12-12', 'fish@lol.com')");
            try (ResultSet result = stat.executeQuery("SELECT * FROM FRIENDS")) {
                while(result.next()){
                    for(int i=1;i<=6;i++)
                    System.out.printf(result.getString(i)+"  ");
                    System.out.println();
                }
            }

        }
    }

}
