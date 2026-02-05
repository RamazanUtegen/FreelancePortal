package freelancee.controller;

import freelancee.dao.FreelancerDAO;
import freelancee.dao.JobListingDAO;
import freelancee.dao.IGenericDAO;
import freelancee.model.Freelancer;
import freelancee.model.JobListing;
import freelancee.exception.EntityNotFoundException;
import io.javalin.Javalin;

public class RestServer {
    public static void main(String[] args) {


        IGenericDAO<Freelancer> freelancerDAO = new FreelancerDAO();
        IGenericDAO<JobListing> jobDAO = new JobListingDAO();

        Javalin app = Javalin.create().start(7000);


        app.exception(EntityNotFoundException.class, (e, ctx) -> {
            ctx.status(404).result(e.getMessage());
        });


        app.get("/freelancers", ctx -> ctx.json(freelancerDAO.getAll()));

        app.post("/freelancers", ctx -> {
            Freelancer f = ctx.bodyAsClass(Freelancer.class);
            freelancerDAO.add(f);
            ctx.status(201).result("Freelancer created");
        });


        app.get("/jobs", ctx -> ctx.json(jobDAO.getAll()));


        app.post("/jobs/builder-demo", ctx -> {
            JobListing job = new JobListing.Builder()
                    .setTitle("Job Created with Builder")
                    .setPrice(999.0)
                    .build();
            jobDAO.add(job);
            ctx.result("Job added using Design Pattern: Builder");
        });

        app.post("/jobs", ctx -> {
            JobListing job = ctx.bodyAsClass(JobListing.class);
            jobDAO.add(job);
            ctx.status(201).result("Job created");
        });
    }
}