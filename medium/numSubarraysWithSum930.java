import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class numSubarraysWithSum930 {
    public static void main(String[] args) {
        numSubarraysWithSum930 tmp = new numSubarraysWithSum930();
//        int[] a = new int[]{1, 0, 1, 0, 1};
//        int s = 2;
        int[] a = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
//        int[] a = new int[]{1, 1, 1, 1, 1};
        int s = 0;

        int ans = tmp.numSubarraysWithSum(a, s);
        System.out.println(ans);
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int[] count = new int[A.length + 1];
        count[0] = 1;
        int preSum = 0;
        int res = 0;
        for (int i : A) {
            preSum += i;
            if (preSum >= S) res += count[preSum - S];
            count[preSum]++;
        }
        return res;
    }


    public int numSubarraysWithSumSlidingWindow(int[] A, int S) {

        return 0;
    }
}
