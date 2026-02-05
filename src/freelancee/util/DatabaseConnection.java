package freelancee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;


    private DatabaseConnection() {
        try {
            // ВСТАВЬ СЮДА СВОИ ДАННЫЕ ОТ POSTGRES
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "87014667858");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}