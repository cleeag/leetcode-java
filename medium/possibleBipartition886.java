import java.util.*;

public class possibleBipartition886 {
    public static void main(String[] args) {
//        int[][] dislikes =  new int[][] {{1,2},{1,3},{2,4}};
//        int[][] dislikes =  new int[][] {{1,2},{1,3},{2,3}};
        int N = 5;
        int[][] dislikes = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};

//        int N = 10;
//        int[][] dislikes = new int[][]{{4, 7}, {4, 8}, {5, 6}, {1, 6}, {3, 7}, {2, 5}, {5, 8}, {1, 2}, {4, 9}, {6, 10}, {8, 10}, {3, 6}, {2, 10}, {9, 10}, {3, 9}, {2, 3}, {1, 9}, {4, 6}, {5, 7}, {3, 8}, {1, 8}, {1, 7}, {2, 4}};
        possibleBipartition886 tmp = new possibleBipartition886();
        System.out.println(tmp.possibleBipartition(N, dislikes));
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i + 1, new HashSet<>());
        for (int[] pair : dislikes) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }
        Set<Integer> group1 = new HashSet<>();
        Set<Integer> group2 = new HashSet<>();
        for (int[] pair : dislikes) {
            if (group1.contains(pair[0]) || group1.contains(pair[1])
                    || group2.contains(pair[0]) || group2.contains(pair[1]))
                continue;
            if (!dfs(graph, group1, group2, pair[0], 1)) return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, Set<Integer>> graph, Set<Integer> group1, Set<Integer> group2, int cur, int flag) {
        int newFlag;
        if (flag == 1) {
            group1.add(cur);
            newFlag = 2;
        } else {
            group2.add(cur);
            newFlag = 1;
        }
        for (Integer adj : graph.get(cur)) {
            if ((flag == 1 && group1.contains(adj)) || (flag == 2 && group2.contains(adj))) return false;
            if (!group1.contains(adj) && !group2.contains(adj))
                if (!dfs(graph, group1, group2, adj, newFlag))
                    return false;
        }
        return true;
    }
}
