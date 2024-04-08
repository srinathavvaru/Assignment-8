import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class restaurantratingtracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ratings = new ArrayList<>();

        System.out.print("Enter the number of restaurants: ");
        int numRestaurants = scanner.nextInt();
        System.out.println("Enter the ratings of each restaurant (out of 10):");
        for (int i = 0; i < numRestaurants; i++) {
            System.out.print("Rating for restaurant " + (i + 1) + ": ");
            int rating = scanner.nextInt();
            ratings.add(rating);
        }

        int minRating = 1;
        int maxRating = 10;
        int numRanges = 2;
        int rangeSize = (maxRating - minRating + 1) / numRanges;

        Map<String, Integer> rangeCounts = new HashMap<>();
        Map<String, Integer> rangeTotalRatings = new HashMap<>();

        for (int i = 0; i < numRanges; i++) {
            String rangeLabel = (minRating + i * rangeSize) + "-" + (minRating + (i + 1) * rangeSize - 1);
            rangeCounts.put(rangeLabel, 0);
            rangeTotalRatings.put(rangeLabel, 0);
        }

        for (int rating : ratings) {
            String rangeLabel = determineRangeLabel(rating, minRating, rangeSize);
            rangeCounts.put(rangeLabel, rangeCounts.get(rangeLabel) + 1);
            rangeTotalRatings.put(rangeLabel, rangeTotalRatings.get(rangeLabel) + rating);
        }

        System.out.println("\nAnalysis:");
        for (Map.Entry<String, Integer> entry : rangeCounts.entrySet()) {
            String rangeLabel = entry.getKey();
            int count = entry.getValue();
            double averageRating = (double) rangeTotalRatings.get(rangeLabel) / count;
            System.out.println("Number of restaurants rated within range " + rangeLabel + ": " + count);
            System.out.println("Average rating for range " + rangeLabel + ": " + averageRating);
            System.out.println();
        }

        scanner.close();
    }

    private static String determineRangeLabel(int rating, int minRating, int rangeSize) {
        int rangeStart = minRating;
        int rangeEnd = minRating + rangeSize - 1;
        for (int i = minRating; i <= 10; i += rangeSize) {
            if (rating >= rangeStart && rating <= rangeEnd) {
                return rangeStart + "-" + rangeEnd;
            }
            rangeStart += rangeSize;
            rangeEnd += rangeSize;
        }
        return null;
    }
}
