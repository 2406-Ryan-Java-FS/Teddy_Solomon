package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            //Establish a new Connection

            try {
                InputStream input = JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties");

                Properties props = new Properties();
                props.load(input);

                String endpoint = props.getProperty("endpoint");
                String database = props.getProperty("database");
                String url = "jdbc:postgresql://" + endpoint + "/" + database;
                String username = props.getProperty("username");
                String password = props.getProperty("password");


                conn = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return conn;

    }

    //This is for testing purposes only. Not needed to actually use JDBC.
    public static void main(String[] args) {

        Connection conn1 = getConnection();
        Connection conn2 = getConnection();

        System.out.println(conn1);
        System.out.println(conn2);

    }

}