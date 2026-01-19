package freelancee;

import java.sql.*;

public class FreelancerDAO {

    // CREATE
    public void addFreelancer(Connection conn, Freelancer freelancer) {
        String sql = "INSERT INTO freelancers (name, skill) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, freelancer.getName());
            ps.setString(2, freelancer.getSkill());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public void getAllFreelancers(Connection conn) {
        String sql = "SELECT * FROM freelancers";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("skill")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateSkill(Connection conn, int id, String newSkill) {
        String sql = "UPDATE freelancers SET skill = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newSkill);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteFreelancer(Connection conn, int id) {
        String sql = "DELETE FROM freelancers WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
