import java.util.*;

public class isBipartite785 {

    public static void main(String[] args) {
        int[][] g = {{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        isBipartite785 tmp = new isBipartite785();
        System.out.println(tmp.isBipartite(g));

    }
    public boolean isBipartite(int[][] graph) {
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int nodeIdx = 0; nodeIdx < graph.length; nodeIdx++) {
            if (!left.contains(nodeIdx) && !right.contains(nodeIdx))q.add(nodeIdx);
            int i = 0;
            while (!q.isEmpty()){
                Queue<Integer> newQ = new LinkedList<>();
                if (i % 2 == 0)left.addAll(q);
                else right.addAll(q);
                for (Integer node : q) {
                    for (int child : graph[node]) {
                        if (!left.contains(child) && !right.contains(child)) newQ.offer(child);
                    }
                }
                q = newQ;
                i++;
            }  
        }
        
        System.out.println(left);
        System.out.println(right);
        for (Integer node : left) {
            for (int child : graph[node]) {
                if (left.contains(child)) return false;
            }
        }
        for (Integer node : right) {
            for (int child : graph[node]) {
                if (right.contains(child)) return false;
            }
        }
        return true;
    }
}
