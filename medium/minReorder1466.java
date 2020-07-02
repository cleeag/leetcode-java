import java.net.ConnectException;
import java.util.*;

public class minReorder1466 {
    public static void main(String[] args) {
//        int n = 6;
//        int[][] a = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

//        int[][] a = new int[][]{{1,0},{1,2},{3,2},{3,4}};
//        int n = 5;

        int[][] a = new int[][]{{1,0},{2, 0}};
        int n = 3;


        minReorder1466 tmp = new minReorder1466();
        tmp.minReorder(n, a);
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> orgGraph = new HashMap<>();
        Map<Integer, List<Integer>> revGraph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            orgGraph.put(i, new LinkedList<>());
            revGraph.put(i, new LinkedList<>());
        }
        for (int[] connection : connections) {
            orgGraph.get(connection[0]).add(connection[1]);
            revGraph.get(connection[1]).add(connection[0]);
        }

        int ans = dfs(orgGraph, revGraph, 0, -1);
        return ans;

    }

    public int dfs(Map<Integer, List<Integer>> orgGraph, Map<Integer, List<Integer>> revGraph, int curNode, int prevNode) {
        if (revGraph.get(curNode).size() == 0 && orgGraph.get(curNode).size() == 0) return 0;

        int revs = 0;
        if (orgGraph.get(curNode).size() > 0) {
            for (int nextNode : orgGraph.get(curNode)) {
                if (nextNode != prevNode) revs += dfs(orgGraph, revGraph, nextNode, curNode) + 1;
            }
        }
        if (revGraph.get(curNode).size() > 0) {
            for (int nextNode : revGraph.get(curNode)) {
                if (nextNode != prevNode) revs += dfs(orgGraph, revGraph, nextNode, curNode);
            }
        }
        return revs;
    }
}
