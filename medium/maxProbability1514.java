import java.util.*;

public class maxProbability1514 {
    public static void main(String[] args) {
        int n = 3, start = 0, end = 2;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
//        int[][] edges = {{0, 1}};
//        double[] succProb = {0.5};

        maxProbability1514 tmp = new maxProbability1514();
        System.out.println(tmp.maxProbability(n, edges, succProb, start, end));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new HashMap<>());
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).put(edge[1], succProb[i]);
            graph.get(edge[1]).put(edge[0], succProb[i]);
        }
        double[] probs = new double[n];
        probs[start] = 1.0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
//            System.out.println(q);
//            System.out.println(graph);
            int node = q.poll();
            Map<Integer, Double> adjs = graph.get(node);
            for (Integer nextNode : adjs.keySet()) {
                if (probs[node] * adjs.get(nextNode) > probs[nextNode]){
                    probs[nextNode] = probs[node] * adjs.get(nextNode);
                    q.add(nextNode);
                }
//                graph.get(nextNode).remove(node);
            }
        }
        return probs[end];
    }
}
