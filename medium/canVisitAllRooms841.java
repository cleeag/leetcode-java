import java.util.*;

public class canVisitAllRooms841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            graph.put(i, new HashSet<>());
            for (int j = 0; j < rooms.get(i).size(); j++) {
                graph.get(i).add(rooms.get(i).get(j));
            }
        }
        dfs(graph, visited, 0);
        return visited.size() == rooms.size();
    }

    public void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, int cur){
        visited.add(cur);
        System.out.println(visited);
        for (Integer nextRoom : graph.get(cur)) {
            if (visited.contains(nextRoom)) continue;
            dfs(graph, visited, nextRoom);
        }
    }
}
