package freelancee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Portal {
    private String name;
    private List<Freelancer> freelancers;
    private List<JobListing> jobs;

    public Portal(String name) {
        this.name = name;
        freelancers = new ArrayList<>();
        jobs = new ArrayList<>();
    }

    public void addFreelancer(Freelancer freelancer) {
        freelancers.add(freelancer);
    }

    public void addJob(JobListing job) {
        jobs.add(job);
    }

    public List<Freelancer> findFreelancersBySkill(String skill) {
        return freelancers.stream()
                .filter(f -> f.getSkill().equalsIgnoreCase(skill))
                .collect(Collectors.toList());
    }

    public List<JobListing> sortJobsByPrice() {
        return jobs.stream()
                .sorted(Comparator.comparingDouble(JobListing::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Portal{" + "name='" + name + '\'' + '}';
    }
}