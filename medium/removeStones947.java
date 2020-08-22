import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class removeStones947 {
    public static void main(String[] args) {
        int[][] s = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};

        removeStones947 tmp = new removeStones947();
        System.out.println(tmp.removeStones(s));
    }
    public int removeStones(int[][] stones) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if (!graph.containsKey(i)) graph.put(i, new HashSet<>());
            int[] p1 = stones[i];
            for (int j = i + 1; j < stones.length; j++) {
                if (!graph.containsKey(j)) graph.put(j, new HashSet<>());
                int[] p2 = stones[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        System.out.println(graph);
        Set<Integer> seen = new HashSet<>();
        int removes = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (seen.contains(i)) continue;
            removes += dfs(graph, seen, i);
        }
        return removes;
    }

    public int dfs(Map<Integer, Set<Integer>> graph, Set<Integer> seen, int curNode) {
        System.out.println(curNode);
        System.out.println(seen);
        Set<Integer> adj = graph.get(curNode);
        seen.add(curNode);
        int removes = 0;
        for (Integer nextNode : adj) {
            if (seen.contains(nextNode)) continue;
            removes += dfs(graph, seen, nextNode) + 1;
        }
        System.out.println(removes);
        return removes;
    }
}
