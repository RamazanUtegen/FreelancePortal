package freelancee;

import java.sql.*;

public class JobListingDAO {

    public void addJob(Connection conn, JobListing job) {
        String sql = "INSERT INTO job_listings (title, price) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, job.getTitle());
            ps.setDouble(2, job.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllJobs(Connection conn) {
        String sql = "SELECT * FROM job_listings";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getDouble("price")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
