import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class threeSumMulti923 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int t = 8;
//        int[] a = new int[]{1, 1, 2, 2, 2, 2};
//        int t = 5;
//        int[] a = new int[]{0, 0, 0};
//        int t = 0;
//        int[] a = new int[]{1,2,0,3,2};
//        int t = 4;

        threeSumMulti923 tmp = new threeSumMulti923();
        System.out.println(tmp.threeSumMulti(a, t));
    }

    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        double mod = 1e9 + 7;
        for (int value : A) {
            hMap.put(value, (int) ((hMap.getOrDefault(value, 0) + 1) % mod));
        }
        Arrays.sort(A);
        long ans = 0;
        int i = 0, j = i, k = A.length - 1;
        while (j < A.length) {
            i = 0;
            k = A.length - 1;
            while (i < A.length && A[i] <= A[j] && A[k] >= A[j]) {
                int sum = A[i] + A[j] + A[k];
                if (sum == target) {
//                    System.out.println("sum is: " + A[i] + " " + A[j] + " " + A[k]);
                    if (A[i] == A[j] && A[i] == A[k]) {
                        int tmp = hMap.get(A[i]);
                        if (tmp >= 3) {
                            long tmp1 =  ((tmp * (tmp - 1)));
                            long tmp2 =  ((tmp1 * (tmp - 2)));
                            ans =  (long)((ans + tmp2 / (3 * 2)) % mod);
                        }
                    } else if (A[i] == A[j]) {
                        int tmp = hMap.get(A[i]);
                        if (tmp >= 2) ans = (int) (ans + (tmp * (tmp - 1) / 2 * hMap.get(A[k])) % mod);
                    } else if (A[j] == A[k]) {
                        int tmp = hMap.get(A[j]);
                        if (tmp >= 2) ans = (int) (ans + (tmp * (tmp - 1) / 2 * hMap.get(A[i])) % mod);
                    } else {
                        ans = (int) (ans + (hMap.get(A[i]) * hMap.get(A[j]) * hMap.get(A[k])) % mod);
                    }
                    ans %= mod;
                }

                if (sum >= target) {
                    int top = A[k];
                    while (k >= 0 && A[k] == top) k--;
                } else {
                    int bot = A[i];
                    while (i < A.length && A[i] == bot) i++;
                }
                if (i < 0 || i >= A.length || k < 0 || k >= A.length) break;
            }
            int last = A[j];
            while (j < A.length && A[j] == last) j++;
//            System.out.println(i + " " + j + " " + k + " " + ans);
//            System.out.println();
        }
//        System.out.println(Arrays.toString(A));
        return (int) ans;
    }
}
