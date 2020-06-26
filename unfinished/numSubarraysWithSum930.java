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
        int left=0, leftPrev=0;
        int right=0, rightNext=0;
        int count = 0;
        int sum = 0;
        while (sum < S && right < A.length) {
            if (A[right] == 1) {
                sum += 1;
                right++;
            }
        }
        if (right == A.length && sum < S) return 0;

        return 0;

    }


    public int numSubarraysWithSumFailed(int[] A, int S) {
        List<Integer> ones = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) ones.add(i);
        }
        if (ones.size() < S) return 0;
        else if (S == 0) {
            int ans = 0;
            int i = 1;

            while (i <= A.length) {
                ans += i;
                i += 1;
            }
            return ans;
        }
        System.out.println(ones);

        int i = 0;
        int count = 0;
        while (i + S - 1 < ones.size()) {
            int addition, left, right;

            if (i == 0) left = (ones.get(i) + 1);
            else left = (ones.get(i) - ones.get(i - 1));
            if (i + S == ones.size()) right = (Math.max(1, A.length - ones.get(i + S - 1)));
            else right = (ones.get(i + S) - ones.get(i + S - 1));
            count += left * right;
            System.out.println(count + " " + i + " " + left + " " + right);
            i += 1;
        }
        return count;
    }
}
