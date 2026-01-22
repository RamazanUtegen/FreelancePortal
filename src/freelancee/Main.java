package freelancee;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.connect("postgres", "postgres", "87014667858");

        if (conn == null) {
            System.out.println("Database connection failed");
            return;
        }

        FreelancerDAO freelancerDAO = new FreelancerDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== FREELANCE PORTAL ===");
            System.out.println("1. Add freelancer");
            System.out.println("2. View freelancers");
            System.out.println("3. Update freelancer skill");
            System.out.println("4. Delete freelancer");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter skill: ");
                    String skill = scanner.nextLine();
                    freelancerDAO.addFreelancer(conn, new Freelancer(name, skill));
                    break;

                case 2:
                    freelancerDAO.getAllFreelancers(conn);
                    break;

                case 3:
                    System.out.print("Enter freelancer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new skill: ");
                    String newSkill = scanner.nextLine();
                    freelancerDAO.updateFreelancerSkill(conn, id, newSkill);
                    break;

                case 4:
                    System.out.print("Enter freelancer ID: ");
                    int deleteId = scanner.nextInt();
                    freelancerDAO.deleteFreelancer(conn, deleteId);
                    break;

                case 0:
                    System.out.println("Program finished");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
