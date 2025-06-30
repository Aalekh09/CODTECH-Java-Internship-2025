package Task4_RecommendationSystem;
import java.io.*;
import java.util.*;

public class RecommendationSystem {
    // Map of user -> (item -> rating)
    private static Map<String, Map<String, Integer>> userRatings = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // Load ratings from CSV
        loadRatings("Task4_RecommendationSystem/sample_data.csv");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name for recommendations: ");
        String user = scanner.nextLine();
        List<String> recommendations = recommend(user);
        System.out.println("Recommended items for " + user + ": " + recommendations);
    }

    // Load user-item ratings from CSV file
    private static void loadRatings(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            String user = parts[0];
            String item = parts[1];
            int rating = Integer.parseInt(parts[2].trim());
            userRatings.putIfAbsent(user, new HashMap<>());
            userRatings.get(user).put(item, rating);
        }
        br.close();
    }

    // Recommend items to a user based on similar users
    private static List<String> recommend(String user) {
        Map<String, Integer> targetRatings = userRatings.get(user);
        if (targetRatings == null) return Collections.emptyList();
        Map<String, Double> scores = new HashMap<>();
        for (String otherUser : userRatings.keySet()) {
            if (otherUser.equals(user)) continue;
            double similarity = cosineSimilarity(targetRatings, userRatings.get(otherUser));
            for (String item : userRatings.get(otherUser).keySet()) {
                if (!targetRatings.containsKey(item)) {
                    scores.put(item, scores.getOrDefault(item, 0.0) + similarity);
                }
            }
        }
        // Sort items by score
        List<String> recommended = new ArrayList<>(scores.keySet());
        recommended.sort((a, b) -> Double.compare(scores.get(b), scores.get(a)));
        return recommended;
    }

    // Compute cosine similarity between two users
    private static double cosineSimilarity(Map<String, Integer> a, Map<String, Integer> b) {
        Set<String> allItems = new HashSet<>(a.keySet());
        allItems.retainAll(b.keySet());
        if (allItems.isEmpty()) return 0.0;
        double dot = 0, normA = 0, normB = 0;
        for (String item : allItems) {
            dot += a.get(item) * b.get(item);
        }
        for (int v : a.values()) normA += v * v;
        for (int v : b.values()) normB += v * v;
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
} 