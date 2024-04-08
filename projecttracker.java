import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Project {
    private String studentName;
    private int completionTime; // in days
    private boolean onTime;

    public Project(String studentName, int completionTime, boolean onTime) {
        this.studentName = studentName;
        this.completionTime = completionTime;
        this.onTime = onTime;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    public boolean isOnTime() {
        return onTime;
    }
}

public class projecttracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Project> projects = new ArrayList<>();

        System.out.print("Enter the number of projects: ");
        int numProjects = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input project details
        for (int i = 0; i < numProjects; i++) {
            System.out.println("\nEnter details for project " + (i + 1) + ":");
            System.out.print("Student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Completion time (in days): ");
            int completionTime = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Was the project completed on time? (true/false): ");
            boolean onTime = Boolean.parseBoolean(scanner.nextLine());

            projects.add(new Project(studentName, completionTime, onTime));
        }

        // Calculate statistics
        int onTimeCount = 0;
        int lateCount = 0;
        int earlyCount = 0;
        int totalCompletionTime = 0;

        for (Project project : projects) {
            if (project.isOnTime())
                onTimeCount++;
            else if (project.getCompletionTime() > 10) // Assuming 10 days is the deadline
                lateCount++;
            else
                earlyCount++;

            totalCompletionTime += project.getCompletionTime();
        }

        int totalProjects = projects.size();
        double averageCompletionTime = (double) totalCompletionTime / totalProjects;

        // Print statistics
        System.out.println("\nStatistics:");
        System.out.println("Number of projects completed on time: " + onTimeCount);
        System.out.println("Number of projects completed late: " + lateCount);
        System.out.println("Number of projects completed early: " + earlyCount);
        System.out.println("Average completion time: " + averageCompletionTime + " days");

        // Close scanner
        scanner.close();
    }
}
