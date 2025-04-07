package bcs.csc411.csc411project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    final static String DB_URL = "jdbc:mysql://localhost:3306/csc411db";
    final static String username = "csc411user";
    final static String password = "csc411pwd";

    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, username, password);

            System.out.println("Connect to DB");
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void createUserTable(){
        Connection conn = null;
        conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "email VARCHAR(32) NOT NULL PRIMARY KEY," +
                    "salt VARCHAR(64) NOT NULL, " +
                    "password VARCHAR(512) NOT NULL)";
            stmt.execute(query);
            System.out.println("The user table is ready");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
