package freelancee;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.connect("postgres", "postgres", "87014667858");

        if (conn == null) {
            return;
        }

        FreelancerDAO freelancerDAO = new FreelancerDAO();
        JobListingDAO jobListingDAO = new JobListingDAO();

        freelancerDAO.addFreelancer(conn, new Freelancer("Ramazan", "Fullstack Dev"));
        freelancerDAO.getAllFreelancers(conn);
        freelancerDAO.updateSkill(conn, 1, "Java + PostgreSQL");
        freelancerDAO.deleteFreelancer(conn, 2);

        jobListingDAO.getAllJobs(conn);
    }
}
