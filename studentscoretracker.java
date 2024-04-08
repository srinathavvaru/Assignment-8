import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class studentscoretracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> scores = new ArrayList<>();

        // Input scores
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        System.out.println("Enter the scores of each student:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Score for student " + (i + 1) + ": ");
            int score = scanner.nextInt();
            scores.add(score);
        }

        // Calculate average score
        double totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        double averageScore = totalScore / numStudents;

        // Calculate median score
        Collections.sort(scores);
        double medianScore;
        if (numStudents % 2 == 0) {
            medianScore = (scores.get(numStudents / 2 - 1) + scores.get(numStudents / 2)) / 2.0;
        } else {
            medianScore = scores.get(numStudents / 2);
        }

        // Count students above, at, and below average
        int aboveAverage = 0;
        int atAverage = 0;
        int belowAverage = 0;
        for (int score : scores) {
            if (score > averageScore) {
                aboveAverage++;
            } else if (score < averageScore) {
                belowAverage++;
            } else {
                atAverage++;
            }
        }

        // Print results
        System.out.println("\nAnalysis:");
        System.out.println("Average score: " + averageScore);
        System.out.println("Median score: " + medianScore);
        System.out.println("Number of students above average: " + aboveAverage);
        System.out.println("Number of students at average: " + atAverage);
        System.out.println("Number of students below average: " + belowAverage);

        // Close scanner
        scanner.close();
    }
}
