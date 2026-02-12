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

        // 1. Создаем подключение к базе данных через DAO
        IGenericDAO<Freelancer> freelancerDAO = new FreelancerDAO();
        IGenericDAO<JobListing> jobDAO = new JobListingDAO();

        // 2. Запускаем сервер на порту 7000
        Javalin app = Javalin.create().start(7000);

        // --- ВАЖНО: РАЗРЕШАЕМ ДОСТУП ДЛЯ САЙТА (CORS) ---
        // Это позволяет браузеру отправлять данные с index.html на localhost:7000
        app.before(ctx -> {
            ctx.header("Access-Control-Allow-Origin", "*");
            ctx.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            ctx.header("Access-Control-Allow-Headers", "*");
        });

        // Обработка предварительных запросов браузера (Preflight checks)
        app.options("/*", ctx -> {
            ctx.header("Access-Control-Allow-Origin", "*");
            ctx.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            ctx.header("Access-Control-Allow-Headers", "*");
            ctx.status(200);
        });
        // ------------------------------------------------

        // 3. Обработка ошибок (Exception Handling)
        app.exception(EntityNotFoundException.class, (e, ctx) -> {
            ctx.status(404).result(e.getMessage());
        });

        // --- ENDPOINTS (Точки входа) ---

        // Получить всех фрилансеров
        app.get("/freelancers", ctx -> {
            ctx.json(freelancerDAO.getAll());
        });

        // Добавить фрилансера
        app.post("/freelancers", ctx -> {
            try {
                Freelancer f = ctx.bodyAsClass(Freelancer.class);
                freelancerDAO.add(f);
                ctx.status(201).result("Freelancer created");
            } catch (Exception e) {
                ctx.status(400).result("Error adding freelancer: " + e.getMessage());
            }
        });

        // Получить все вакансии
        app.get("/jobs", ctx -> {
            ctx.json(jobDAO.getAll());
        });

        // Добавить вакансию
        app.post("/jobs", ctx -> {
            try {
                JobListing job = ctx.bodyAsClass(JobListing.class);
                jobDAO.add(job);
                ctx.status(201).result("Job created");
            } catch (Exception e) {
                ctx.status(400).result("Error adding job: " + e.getMessage());
            }
        });

        System.out.println("✅ Server is running! Open index.html to test.");
    }
}