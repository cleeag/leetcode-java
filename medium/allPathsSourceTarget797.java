import java.util.LinkedList;
import java.util.List;

public class allPathsSourceTarget797 {
    List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        if (graph.length == 0) return ans;

        List<Integer> path = new LinkedList<>();
        path.add(0);
        dfs(path, graph, new int[graph.length], 0);
        return ans;
    }

    public void dfs(List<Integer> path, int[][] graph, int[] tracker, int cur) {
        tracker[cur] = 1;
        if (cur == graph.length - 1) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < graph[cur].length; i++) {
            int nextNode = graph[cur][i];
            if (tracker[nextNode] == 0) {
                tracker[nextNode] = 1;
                List<Integer> newPath = new LinkedList<>(path);
                newPath.add(nextNode);
                dfs(newPath, graph, tracker, nextNode);
                tracker[nextNode] = 0;
            }
        }
    }
}
