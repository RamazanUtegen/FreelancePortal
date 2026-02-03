package freelancee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FreelancerDAO {

    public void addFreelancer(Connection conn, Freelancer freelancer) {
        try {
            String sql = "INSERT INTO freelancers (name, skill) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, freelancer.getName());
            ps.setString(2, freelancer.getSkill());
            ps.executeUpdate();
            System.out.println("Freelancer added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Freelancer> getAllFreelancers(Connection conn) {
        List<Freelancer> freelancers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM freelancers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String skill = rs.getString("skill");
                freelancers.add(new Freelancer(name, skill));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return freelancers;
    }

    public void updateFreelancerSkill(Connection conn, int id, String skill) {
        try {
            String sql = "UPDATE freelancers SET skill = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, skill);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Freelancer skill updated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteFreelancer(Connection conn, int id) {
        try {
            String sql = "DELETE FROM freelancers WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Freelancer deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}