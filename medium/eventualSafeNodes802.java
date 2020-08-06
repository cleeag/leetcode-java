import java.util.*;

public class eventualSafeNodes802 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
//        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        eventualSafeNodes802 tmp = new eventualSafeNodes802();
        tmp.eventualSafeNodes(graph);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
//        Set<Integer> res = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int[] state = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, state, i)) ans.add(i);
        }
        System.out.println(ans);
        return ans;
    }
    public boolean dfs(int[][] graph, int[] state, int cur){
        if (state[cur] != 0) return state[cur] == 1;

        state[cur] = 2;
        for (int adj : graph[cur]) {
            if (!dfs(graph, state, adj)) return false;
        }
        state[cur] = 1;
        return true;
    }
}
