import java.util.*;

public class PostAnalyzer {
    HashMap<String, Integer> keywordFrequency = new HashMap<>();
    Set<String> stopWords = Set.of("the", "is", "and", "to", "a");

    public void analyzePosts(List<String> posts) {
        for (String post : posts) {
            String[] words = post.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!stopWords.contains(word) && !word.isEmpty()) {
                    keywordFrequency.put(word, keywordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        }
    }

    public List<Map.Entry<String, Integer>> getTrendingTopics(int topN) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(keywordFrequency.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        return list.subList(0, Math.min(topN, list.size()));
    }
}