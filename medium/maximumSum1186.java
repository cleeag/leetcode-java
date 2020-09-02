import javax.swing.text.MutableAttributeSet;
import java.util.Arrays;

public class maximumSum1186 {
    public static void main(String[] args) {
//        int[] a = new int[]{1,-2,0,3};
        int[] a = new int[]{1,-2,-2,3};
//        int[] a = new int[]{-1, -1, -1, -1};
//        int[] a = new int[]{-1};
//        int[] a = new int[]{1, -1, 2, -7, -2, -1, -7};
//        int[] a = new int[]{1, -2, 3, -9, 5, -8, 3};
//        int[] a = new int[]{1, -4, -5, -2, 5, 0, -1, 2};
//        int[] a = new int[]{11, -8, -7, 3, 12};
//        int[] a = new int[]{11, -10, -11, 8, 7, -6, 9, 4, 11, 6, 5, 0};
//        int[] a = new int[]{8,-1,6,-7,-4,5,-4,7,-6};
//        int[] a = new int[]{-5, 8, -7, 12, 7, 2, -11, 6, -1, 2, -1, 8, -1, 0, 1};
//        int[] a = new int[]{18, 17, -22, -19, -16, 9, -18, 1, -18, 15, -18, 11, 20, 3, 12, -21, 12, -13, 24, -9, 4, 5, -12, 5, 22};
        maximumSum1186 tmp = new maximumSum1186();
        System.out.println(tmp.maximumSum(a));
    }

    public int maximumSum(int[] arr) {
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        int[] maxStartsHere = new int[n];
        int[] maxEndsHere = new int[n];
        maxEndsHere[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndsHere[i] = Math.max(maxEndsHere[i - 1] + arr[i], arr[i]);
        }
        maxStartsHere[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxStartsHere[i] = Math.max(maxStartsHere[i + 1] + arr[i], arr[i]);
        }
        System.out.println(Arrays.toString(maxEndsHere));
        System.out.println(Arrays.toString(maxStartsHere));
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int maxVal;
            if (i == 0) maxVal = Math.max(maxStartsHere[i], maxStartsHere[i + 1] + Math.max(0, arr[i]));
            else if (i == n - 1) maxVal = Math.max( maxEndsHere[i], maxEndsHere[i - 1] + Math.max(0, arr[i]));
            else {
                maxVal = maxEndsHere[i - 1] + maxStartsHere[i + 1] + Math.max(0, arr[i]);
            }
            maxSum = Math.max(maxSum, maxVal);
        }
        return maxSum;
    }

    public int maximumSumFAIL(int[] arr) {
        int n = arr.length;
        int i = 0;
        int sum = 0;
        int anchor = 0;
        int dip = 0;
        int dipSum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (i < n) {
            sum += arr[i];
            maxSum = Math.max(sum - anchor - dip, maxSum);
//            if (arr[i] < dip || sum - anchor - dip <= sum - dipSum - arr[i]) {
            if (sum - anchor - dip <= sum - dipSum - arr[i]) {
                if (dipSum < anchor) anchor = dipSum;
                dip = arr[i];
                dipSum = sum;
            }
            System.out.println(i + " " + arr[i]);
            System.out.println(i + " " + sum + " " + maxSum + " " + anchor + " " + dip + " " + dipSum);
            i++;
        }
        maxSum = Math.max(sum - anchor - dip, maxSum);
        return maxSum;
    }
}
