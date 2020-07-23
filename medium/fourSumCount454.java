import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class fourSumCount454 {
    public static void main(String[] args) {
//        int[]A = { 1, 2};
//        int[]B = {-2,-1};
//        int[]C = {-1, 2};
//        int[]D = { 0, 2};
        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        fourSumCount454 tmp = new fourSumCount454();
        tmp.fourSumCount(A, B, C, D);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, LinkedList<int[]>> abMap = new HashMap<>();
        Map<Integer, LinkedList<int[]>> cdMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = A[i] + B[j];
                if (!abMap.containsKey(tmp)) abMap.put(tmp, new LinkedList<>());
                abMap.get(tmp).add(new int[] {i, j});

                int tmp2 = C[i] + D[j];
                if (!cdMap.containsKey(tmp2)) cdMap.put(tmp2, new LinkedList<>());
                cdMap.get(tmp2).add(new int[] {i, j});
            }
        }
        int ans = 0;
        for (Integer curSum : abMap.keySet()) {
            if (cdMap.containsKey(-curSum))
                ans += abMap.get(curSum).size() * cdMap.get(-curSum).size();
        }
        System.out.println(ans);
        return ans;
    }
}
