package freelancee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAO {

    public void addJob(Connection conn, JobListing job) {
        String sql = "INSERT INTO job_listings (title, price) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, job.getTitle());
            ps.setDouble(2, job.getPrice());
            ps.executeUpdate();
            System.out.println("Job added successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobListing> getAllJobs(Connection conn) {
        List<JobListing> jobs = new ArrayList<>();
        String sql = "SELECT * FROM job_listings";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                jobs.add(new JobListing(title, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobs;
    }
}