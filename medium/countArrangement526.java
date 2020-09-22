import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class countArrangement526 {
    public static void main(String[] args) {
        countArrangement526 tmp = new countArrangement526();
        tmp.countArrangement(10);
    }
    public int countArrangement(int N) {
        Map<Integer, Set<Integer>> hMap = new HashMap<>();
        for (int i = N; i > 0 ; i--) {
            hMap.put(i, new HashSet<>());
            for (int j = N; j > 0; j--) {
                if (i >= j && i % j == 0) hMap.get(i).add(j);
                if (j >= i && j % i == 0) hMap.get(i).add(j);
            }
        }
        System.out.println(hMap);
        return dfs(hMap, new HashSet<>(), 1, N);
    }

    public int dfs(Map<Integer, Set<Integer>> hMap, Set<Integer> path, int idx, int N){
        if (path.size() == N) return 1;
        int sum = 0;
        for(int cand: hMap.get(idx)){
            if(!path.contains(cand)) {
                path.add(cand);
                sum += dfs(hMap, path, idx + 1, N);
                path.remove(cand);
            }
        }
        return sum;
    }
}
