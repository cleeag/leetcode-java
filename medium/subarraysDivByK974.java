import java.util.*;

public class subarraysDivByK974 {
    public static void main(String[] args) {

//        int[] a = new int[]{4, 5, 0, -2, -3, 1};
//        int k = 5;
        int[] a = new int[]{-1, 2, 9};
        int k = 2;
        subarraysDivByK974 tmp = new subarraysDivByK974();
        tmp.subarraysDivByK(a, k);
    }
    public int subarraysDivByK(int[] A, int K) {
        int preSum = 0;
        int ans = 0;
        int[] residuals = new int[K];
        residuals[0] = 1;
        for (int value : A) {
            preSum += value;
            int residual = preSum % K >= 0 ? preSum % K : (preSum % K) + K;
            ans += residuals[residual];
            residuals[residual]++;
        }
        return ans;
    }




    public int subarraysDivByKFUCKED(int[] A, int K) {
        int preSum = 0;
        Map<Integer, Integer> mod = new HashMap<>();
        mod.put(-1, 0);
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            mod.put(i, preSum % K >= 0 ? preSum % K : (preSum % K) + K);
        }
        System.out.println(mod);

        int ans = 0;
        for (int i = -1; i < A.length; i++) {
            for (int j = -1; j < i; j++) {
                if (mod.get(i).equals(mod.get(j))) {
                    System.out.println(j + 1 + " " + (i + 1));
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
