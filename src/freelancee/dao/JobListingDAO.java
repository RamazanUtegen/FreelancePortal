package freelancee.dao;

import freelancee.model.JobListing;
import freelancee.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAO implements IGenericDAO<JobListing> {


    private Connection conn = DatabaseConnection.getInstance().getConnection();

    @Override
    public void add(JobListing job) {
        try {
            String sql = "INSERT INTO job_listings (title, price) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, job.getTitle());
            ps.setDouble(2, job.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JobListing> getAll() {
        List<JobListing> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM job_listings";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                JobListing job = new JobListing.Builder()
                        .setTitle(rs.getString("title"))
                        .setPrice(rs.getDouble("price"))
                        .build();

                list.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}