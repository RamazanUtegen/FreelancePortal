package freelancee;

import io.javalin.Javalin;
import java.sql.Connection;

public class RestServer {

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.connect("postgres", "postgres", "87014667858");

        if (conn == null) {
            System.out.println("Database connection failed. Exiting.");
            return;
        }

        FreelancerDAO freelancerDAO = new FreelancerDAO();
        JobListingDAO jobListingDAO = new JobListingDAO();

        Javalin app = Javalin.create().start(7000);

        app.get("/freelancers", ctx -> {
            ctx.json(freelancerDAO.getAllFreelancers(conn));
        });

        app.post("/freelancers", ctx -> {
            Freelancer newFreelancer = ctx.bodyAsClass(Freelancer.class);
            freelancerDAO.addFreelancer(conn, newFreelancer);
            ctx.status(201).result("Freelancer created");
        });

        app.get("/jobs", ctx -> {
            ctx.json(jobListingDAO.getAllJobs(conn));
        });

        app.post("/jobs", ctx -> {
            JobListing newJob = ctx.bodyAsClass(JobListing.class);
            jobListingDAO.addJob(conn, newJob);
            ctx.status(201).result("Job created");
        });

        System.out.println("Server is running at http://localhost:7000");
    }
}