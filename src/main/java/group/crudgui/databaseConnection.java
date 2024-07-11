package group.crudgui;

import java.sql.*;

public class databaseConnection {

    private static String username = "orion";
    private static String password = "orion";
    private static String database = "DBBancoCentral";
    private static String ip = "localhost";
    private static String portNumber = "1433";

    private static String URL = "jdbc:sqlserver://" + ip + ":" + portNumber + ";" + "databaseName=" + database + ";"
            + "integratedSecurity=true;encrypt=false";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
        return connection;
    }

}
