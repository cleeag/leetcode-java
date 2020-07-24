import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class rangeSum1508 {
    public static void main(String[] args) {
        rangeSum1508 tmp = new rangeSum1508();
        int[] nums = new int[]{1, 2, 3, 4};
        int n = 4;
        int left = 3;
        int right = 4;
        tmp.rangeSum(nums, n, left, right);
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        double mod = 1e9 + 7;
        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(n1 -> n1[0]));
        for (int i = 0; i < n; i++) {
            p.add(new int[]{nums[i], i + 1});
        }

        int count = 1;
        int ans = 0;
        while (count <= right) {
            int[] tmp = p.poll();
            System.out.println(Arrays.toString(tmp));
            if (count >= left) {
                System.out.println(tmp[0]);
                ans = (int) ((ans + tmp[0]) % mod);
            }
            if (tmp[1] < n) {
                tmp[0] = (int) ((tmp[0] + nums[tmp[1]]) % mod);
                tmp[1] += 1;
                p.add(tmp);
            }
            count++;
        }
        System.out.println(ans);
        return ans;
    }

    public int rangeSumSLOW(int[] nums, int n, int left, int right) {
        double mod = 1e9 + 7;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int count = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = (int) ((sum + nums[j]) % mod);
                p.add(sum);
            }
        }
        System.out.println(p);
        while (count < left) {
            System.out.println(p.poll());
            count++;
        }
        count = 0;
        System.out.println();
        while (count < right - left + 1) {
            System.out.println(p.peek());
            ans = (int) ((ans + p.poll()) % mod);
            count++;
        }
        System.out.println(ans);
        return ans;
    }
}
