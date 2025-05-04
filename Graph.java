import java.util.*;

public class Graph {
    Map<String, List<String>> followersMap = new HashMap<>();

    public void addUser(String user) {
        followersMap.putIfAbsent(user, new ArrayList<>());
    }

    public void addFollower(String user, String follower) {
        followersMap.get(user).add(follower);
    }

    public List<String> getTopInfluencers(int topN) {
        Map<String, Integer> followerCount = new HashMap<>();
        for (String user : followersMap.keySet()) {
            for (String follower : followersMap.get(user)) {
                followerCount.put(follower, followerCount.getOrDefault(follower, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(followerCount.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        List<String> topUsers = new ArrayList<>();
        for (int i = 0; i < Math.min(topN, list.size()); i++) {
            topUsers.add(list.get(i).getKey() + " (" + list.get(i).getValue() + " followers)");
        }
        return topUsers;
    }
}