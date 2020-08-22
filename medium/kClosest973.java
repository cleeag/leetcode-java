import java.util.Comparator;
import java.util.PriorityQueue;

public class kClosest973 {
    public int[][] kClosest(int[][] points, int K) {
        return new int[][]{};
    }


    public int[][] kClosestBRUTE(int[][] points, int K) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparing(o1->-distance(points, o1)));
        for (int i = 0; i < points.length; i++) {
            p.offer(i);
            if (p.size() > K) p.poll();
        }
        int[][] ans = new int[K][2];
        while (p.size() > 0) ans[p.size()-1] = points[p.poll()];
        return ans;
    }
    public double distance(int[][] points, int idx){
        return Math.sqrt(Math.pow(points[idx][0], 2) + Math.pow(points[idx][1], 2));
    }
}
