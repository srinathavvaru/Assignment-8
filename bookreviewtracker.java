import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class BookReview {
    private int rating; // Assuming rating is on a scale of 1-10

    public BookReview(String title, int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}

public class bookreviewtracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BookReview> reviews = new ArrayList<>();

        System.out.print("Enter the number of book reviews: ");
        int numReviews = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input review details
        for (int i = 0; i < numReviews; i++) {
            System.out.println("\nEnter details for review " + (i + 1) + ":");
            System.out.print("Book title: ");
            String title = scanner.nextLine();
            System.out.print("Book rating (1-10): ");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            reviews.add(new BookReview(title, rating));
        }

        // Analyze reviews
        Map<String, Integer> ratingRanges = new HashMap<>();
        ratingRanges.put("1-5 stars", 0);
        ratingRanges.put("6-10 stars", 0);

        int positiveReviews = 0;
        int neutralReviews = 0;
        int negativeReviews = 0;

        for (BookReview review : reviews) {
            int rating = review.getRating();

            if (rating >= 1 && rating <= 5) {
                ratingRanges.put("1-5 stars", ratingRanges.get("1-5 stars") + 1);
                if (rating >= 1 && rating <= 3)
                    negativeReviews++;
                else if (rating == 4)
                    neutralReviews++;
                else if (rating == 5)
                    positiveReviews++;
            } else if (rating >= 6 && rating <= 10) {
                ratingRanges.put("6-10 stars", ratingRanges.get("6-10 stars") + 1);
                if (rating >= 6 && rating <= 8)
                    positiveReviews++;
                else if (rating == 9)
                    neutralReviews++;
                else if (rating == 10)
                    positiveReviews++;
            }
        }

        // Print statistics
        System.out.println("\nBook Review Analysis:");
        for (Map.Entry<String, Integer> entry : ratingRanges.entrySet()) {
            System.out.println("Books reviewed within " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Positive reviews: " + positiveReviews);
        System.out.println("Neutral reviews: " + neutralReviews);
        System.out.println("Negative reviews: " + negativeReviews);

        // Close scanner
        scanner.close();
    }
}
