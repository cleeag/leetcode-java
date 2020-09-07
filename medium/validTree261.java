import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class validTree261 {
    Set<Integer> seen = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) return n <= 1;
        Map<Integer, Set<Integer>> hMap = new HashMap<>();
        for(int[]edge: edges){
            if(!hMap.containsKey(edge[0])) hMap.put(edge[0], new HashSet<>());
            if(!hMap.containsKey(edge[1])) hMap.put(edge[1], new HashSet<>());
            hMap.get(edge[0]).add(edge[1]);
            hMap.get(edge[1]).add(edge[0]);
        }
        // System.out.println(hMap);
        boolean res = dfs(hMap, edges[0][0], -1);
        if(seen.size() != n) return false;
        else return res;
    }
    public boolean dfs(Map<Integer, Set<Integer>> hMap, int node, int parent){
        seen.add(node);
        for(int next: hMap.get(node)){
            if(next == parent) continue;
            if(seen.contains(next)) return false;
            if(!dfs(hMap, next, node)) return false;
        }
        return true;
    }
}
