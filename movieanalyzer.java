import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Movie {
    private String rating;
    private double ratingValue;

    public Movie(String title, String rating, double ratingValue) {
        this.rating = rating;
        this.ratingValue = ratingValue;
    }

    public String getRating() {
        return rating;
    }

    public double getRatingValue() {
        return ratingValue;
    }
}

public class movieanalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        System.out.print("Enter the number of movies: ");
        int numMovies = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input movie details
        for (int i = 0; i < numMovies; i++) {
            System.out.println("\nEnter details for movie " + (i + 1) + ":");
            System.out.print("Movie title: ");
            String title = scanner.nextLine();
            System.out.print("Movie rating (e.g., PG, PG-13, R): ");
            String rating = scanner.nextLine();
            System.out.print("Movie rating value (out of 10): ");
            double ratingValue = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            movies.add(new Movie(title, rating, ratingValue));
        }

        // Analyze ratings
        Map<String, Integer> categoryCount = new HashMap<>();
        Map<String, Double> categoryTotalRating = new HashMap<>();

        for (Movie movie : movies) {
            String rating = movie.getRating();
            double ratingValue = movie.getRatingValue();

            categoryCount.put(rating, categoryCount.getOrDefault(rating, 0) + 1);
            categoryTotalRating.put(rating, categoryTotalRating.getOrDefault(rating, 0.0) + ratingValue);
        }

        // Print statistics
        System.out.println("\nMovie Ratings Analysis:");
        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            String category = entry.getKey();
            int count = entry.getValue();
            double totalRating = categoryTotalRating.get(category);
            double averageRating = totalRating / count;

            System.out.println("Category: " + category);
            System.out.println("Number of movies: " + count);
            System.out.println("Average rating: " + averageRating);
            System.out.println();
        }

        // Close scanner
        scanner.close();
    }
}
