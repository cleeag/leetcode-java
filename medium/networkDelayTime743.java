import javax.print.attribute.standard.Destination;
import java.util.*;

public class networkDelayTime743 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int N = 4;
        int k = 2;
        networkDelayTime743 tmp = new networkDelayTime743();
        System.out.println(tmp.networkDelayTime(a, N, k));
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) graph.put(i, new HashMap<>());
        for (int[] time : times) graph.get(time[0]).put(time[1], time[2]);
        System.out.println(graph);
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= N; i++) distance.put(i, Integer.MAX_VALUE);
        distance.put(K, 0);

        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparingInt(o -> distance.get(o)));
        p.offer(K);
        while (p.size() > 0) {
            int cur = p.poll();
            for (Integer destination : graph.get(cur).keySet()) {
                int newDistance = distance.get(cur) + graph.get(cur).get(destination);
                if (newDistance < distance.get(destination)) {
                    distance.put(destination, newDistance);
                    p.offer(destination);
                }
            }
            System.out.println(p);
            System.out.println(distance);
        }
        int maxD = Integer.MIN_VALUE;
        for (Integer dest : distance.keySet()) maxD = Math.max(distance.get(dest), maxD);
        return maxD == Integer.MAX_VALUE ? -1 : maxD;
    }
}
