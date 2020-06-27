import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lenLongestFibSubseq873 {
    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int[][] dp = new int[A.length][A.length];
        Map<Integer, Integer> index = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            index.put(A[j], j);
            for (int i = 0; i < j; i++) {
                int k = index.getOrDefault(A[i] - A[j], -1);
                dp[i][j] = (A[j] - A[i] < A[i] && k > 0) ? dp[k][j] + 1 : 2;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res > 2 ? res : 0;
    }
}
