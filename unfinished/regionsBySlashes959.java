import java.util.*;

public class regionsBySlashes959 {
    public static void main(String[] args) {
        String[] g = new String[]{"\\/","/\\"};
        regionsBySlashes959 tmp = new regionsBySlashes959();
        tmp.regionsBySlashes(g);
    }

    public int regionsBySlashes(String[] grid) {
        Map<int[], Set<int[]>> graph = new HashMap<>();
        Set<int[]> starts = new HashSet<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            String tmp = grid[i];
            int j = 0;
            int buffer = 0;
            while (j + buffer < tmp.length()) {
                if (tmp.charAt(j + buffer) == ' ') {
                    j++;
                    continue;
                }
                int[] p1;
                int[] p2;
                if (tmp.charAt(j + buffer) == '\\') {
                    p1 = new int[]{i, j};
                    p2 = new int[]{i + 1, j + 1};
                    buffer++;
                } else {
                    p1 = new int[]{i, j + 1};
                    p2 = new int[]{i + 1, j};
                }
                if (!graph.containsKey(p1)) graph.put(p1, new HashSet<>());
                if (!graph.containsKey(p2)) graph.put(p2, new HashSet<>());
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
                if (p1[0] == 0 || p1[0] == n || p1[1] == 0 || p1[1] == n) starts.add(p1);
                if (p2[0] == 0 || p2[0] == n || p2[1] == 0 || p2[1] == n) starts.add(p2);
                j++;
            }
        }

        Set<int[]> seen = new HashSet<>();
        int touchDowns = 0;
        for (int[] curNode : starts) {
            if (seen.contains(curNode)) continue;
            touchDowns += dfs(graph, curNode, seen, n);
        }
        return touchDowns;
    }

    public int dfs(Map<int[], Set<int[]>> graph, int[] curNode, Set<int[]> seen, int n) {
        System.out.println(Arrays.toString(curNode));
        for (int[] ints : seen) {
            System.out.println("Seen: ");
            System.out.println(Arrays.toString(ints));
            System.out.println();
        }
        seen.add(curNode);
        int touchDowns = 0;
        if (curNode[0] == 0 || curNode[0] == n || curNode[1] == 0 || curNode[1] == n) touchDowns++;
        for(int[] adj: graph.get(curNode)){
            if (seen.contains(adj)) continue;
            touchDowns += dfs(graph, adj, seen, n);
        }
        return touchDowns;
    }
}
