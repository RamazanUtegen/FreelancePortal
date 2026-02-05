package freelancee.dao;

import freelancee.model.Freelancer;
import freelancee.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreelancerDAO implements IGenericDAO<Freelancer> {


    private Connection conn = DatabaseConnection.getInstance().getConnection();

    @Override
    public void add(Freelancer freelancer) {
        try {
            String sql = "INSERT INTO freelancers (name, skill) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, freelancer.getName());
            ps.setString(2, freelancer.getSkill());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Freelancer> getAll() {
        List<Freelancer> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM freelancers";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                list.add(new Freelancer(rs.getString("name"), rs.getString("skill")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}