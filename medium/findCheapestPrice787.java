import java.util.*;

public class findCheapestPrice787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        for (int[] flight : flights) {
            if (!prices.containsKey(flight[0])) prices.put(flight[0], new HashMap<>());
            prices.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[] {0, src, K+1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops == 0) continue;
            Map<Integer, Integer> adj = prices.getOrDefault(city,  new HashMap<>());
            for (Integer a : adj.keySet()) {
                pq.add(new int[] {price + adj.get(a), a, stops-1});
            }
        }
        return -1;
    }
}
