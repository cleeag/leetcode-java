import java.util.*;

public class minimumCost1135 {
    int[] u;
    public int minimumCost(int N, int[][] connections) {
        u = new int[N + 1];
        Arrays.fill(u, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        for(int[] con: connections) pq.offer(con);

        int cost = 0;
        int components = N;
        while(pq.size()>0){
            int[] curEdge = pq.poll();
            int x = curEdge[0], y = curEdge[1];
            if(find(x) == find(y)) continue;
            union(x, y);
            components--;
            cost += curEdge[2];
        }
        return components == 1? cost:-1;
    }
    public void union(int x, int y){
        u[find(x)] = u[find(y)];
    }

    public int find(int num){
        if(u[num] == -1) u[num] = num;
        if(u[num] != num) u[num] = find(u[num]);
        return u[num];
    }
}
