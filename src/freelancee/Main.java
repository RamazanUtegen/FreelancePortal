package freelancee;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal("FreelanceHub");

        Freelancer f1 = new Freelancer("Alex", "Java");
        Freelancer f2 = new Freelancer("Maria", "Java");
        Freelancer f3 = new Freelancer("John", "Python");

        JobListing j1 = new JobListing("Website Development", 5000);
        JobListing j2 = new JobListing("Mobile App", 700);

        portal.addFreelancer(f1);
        portal.addFreelancer(f2);
        portal.addFreelancer(f3);

        portal.addJob(j1);
        portal.addJob(j2);

        System.out.println(portal);
        System.out.println(f1);
        System.out.println(j1);

        System.out.println(f1.equals(f2));
        System.out.println(portal.findFreelancersBySkill("Java"));
        System.out.println(portal.sortJobsByPrice());
    }
}