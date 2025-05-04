import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Analyze posts
        PostAnalyzer analyzer = new PostAnalyzer();
        List<String> posts = List.of(
            "Java is awesome and powerful",
            "Data Structures in Java are important",
            "Graphs and HashMaps are useful in Java"
        );
        analyzer.analyzePosts(posts);
        System.out.println("Trending Topics:");
        System.out.println(analyzer.getTrendingTopics(3));

        // Analyze influencers
        Graph graph = new Graph();
        graph.addUser("Alice");
        graph.addUser("Bob");
        graph.addUser("Charlie");
        graph.addFollower("Alice", "Bob");
        graph.addFollower("Alice", "Charlie");
        graph.addFollower("Bob", "Charlie");

        System.out.println("Top Influencers:");
        System.out.println(graph.getTopInfluencers(2));
    }
}