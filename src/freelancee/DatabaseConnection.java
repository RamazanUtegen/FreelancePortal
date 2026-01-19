package freelancee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String DRIVER = "org.postgresql.Driver";

    public Connection connect(String dbName, String user, String password) {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL + dbName, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
            return null;
        }
    }
}
