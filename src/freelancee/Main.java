package freelancee;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
        // 1. ПОДКЛЮЧЕНИЕ
        DatabaseConnection db = new DatabaseConnection();
        // Твой пароль
        Connection conn = db.connect_to_db("postgres", "postgres", "87014667858");

        if (conn == null) {
            System.out.println("❌ Ошибка: не удалось подключиться к базе.");
            return;
        }
        System.out.println("✅ База данных успешно подключена!");

        try {
            Statement stmt = conn.createStatement();

            // 2. ДОБАВЛЕНИЕ (WRITE)
            // Добавляем фрилансера Ramazan, если его еще нет
            // (Если запустишь второй раз, он добавится снова, это нормально для теста)
            String sqlInsert = "INSERT INTO freelancers (name, skill) VALUES ('Ramazan', 'Fullstack Dev')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("\n[Action] Добавлен новый фрилансер.");

            // 3. ЧТЕНИЕ (READ) - Фрилансеры
            System.out.println("\n--- СПИСОК ФРИЛАНСЕРОВ ---");
            ResultSet rs = stmt.executeQuery("SELECT * FROM freelancers");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | " + rs.getString("name") + " (" + rs.getString("skill") + ")");
            }

            // 4. ЧТЕНИЕ (READ) - Вакансии
            System.out.println("\n--- СПИСОК ВАКАНСИЙ ---");
            ResultSet rsJobs = stmt.executeQuery("SELECT * FROM job_listings");
            while (rsJobs.next()) {
                System.out.println("Job: " + rsJobs.getString("title") + " - " + rsJobs.getDouble("price") + "$");
            }

        } catch (Exception e) {
            System.out.println("Ошибка SQL: " + e.getMessage());
        }
    }
}