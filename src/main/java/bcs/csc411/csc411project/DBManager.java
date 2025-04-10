package bcs.csc411.csc411project;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class DBManager {
    final static String DB_URL = "jdbc:mysql://localhost:3306/csc411db";


    public static Connection getConnection(){
        Connection conn = null;
        try{
            File file = new File("csc411db.conf");
            //Solves a bug that you have with getting file for csc325
            Scanner infile = new Scanner(file, "utf-8");
            String username = infile.next();
            String password = infile.next();

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, username, password);

            System.out.println("Connect to DB");
        }
        catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void createUserTable(){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS users (" +
                    "email VARCHAR(32) NOT NULL PRIMARY KEY," +
                    "salt VARCHAR(64) NOT NULL, " +
                    "password VARCHAR(512) NOT NULL)";
            stmt.execute(query);
            System.out.println("The user table is ready");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Exception when closing the connection");
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("Exception when closing the resource");
                }
            }
        }
    }

    public static void addUser(User user){
        String query = "INSERT INTO users (email, salt, password) VALUES (?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getSalt());
            stmt.setString(3, user.getPassword());
            int row = stmt.executeUpdate();
            System.out.println(row + " added to the users table");

        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
}
