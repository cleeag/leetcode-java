import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class numFactoredBinaryTrees823 {
    public static void main(String[] args) {
//        int[] a = new int[]{2, 4, 5, 10};
        int[] a = new int[]{2, 4};
        numFactoredBinaryTrees823 tmp = new numFactoredBinaryTrees823();
        tmp.numFactoredBinaryTrees(a);
    }

    public int numFactoredBinaryTrees(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        Map<Integer, Integer> hMap = new HashMap<>();
        hMap.put(A[0], 1);

        double ans = 1;
        double mod = 1e9 + 7;
        for (int i = 1; i < A.length; i++) {
            hMap.put(A[i], 1);
            ans += 1;
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0 && hMap.containsKey(A[i] / A[j])) {
                    double res = ((hMap.get(A[j]) % mod) * (hMap.get(A[i] / A[j]) % mod)) % mod;
                    ans = (ans + res) % mod;
                    hMap.put(A[i], (int)((hMap.get(A[i]) + (int) res) % mod));
                }
                System.out.println(i + " " + j + " " + ans);
                System.out.println(hMap);
            }
        }
        return (int) ans;
    }
}
