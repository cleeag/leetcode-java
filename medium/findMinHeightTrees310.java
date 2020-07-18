import java.util.*;

public class findMinHeightTrees310 {
    public static void main(String[] args) {
//        int [][] edges = new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
//        int[][] edges = new int[][] {{1, 0}, {1, 2}, {1, 3}};

        int[][] edges = new int[][]{{0, 1}, {0, 2}};
        findMinHeightTrees310 tmp = new findMinHeightTrees310();
        tmp.findMinHeightTrees(3, edges);
//        List<Integer> test = new LinkedList<>();
//        test.add(300);
//        test.add(3);
//        int a = test.get(1);
//        test.remove(Integer.valueOf(a));
//        System.out.println(test);

    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) return new LinkedList<>(Arrays.asList(0));
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new LinkedList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Integer node : graph.keySet()) {
            if (graph.get(node).size() == 1) q.add(node);
        }
        while (!q.isEmpty()) {
            if (q.size() == 1 || graph.size() == 2) break;
            Queue<Integer> newQ = new LinkedList<>();
            for (Integer node : q) {
                int leafCand = graph.get(node).get(0);
                graph.get(leafCand).remove(Integer.valueOf(node));
                if (graph.get(leafCand).size() == 1) {
                    newQ.add(leafCand);
                }
                graph.remove(node);
            }
//            System.out.println(newQ);
            if (newQ.size() > 0) q = newQ;
            else break;
        }
        return new LinkedList<>(q);
    }
}
