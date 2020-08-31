import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class maxSlidingWindow239 {
    public static void main(String[] args) {
        int[] n = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 1;
//        int[] n = new int[] {1,3,1,2,0,5};
//        int k = 3;
        maxSlidingWindow239 tmp = new maxSlidingWindow239();
        tmp.maxSlidingWindow(n, k);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[]{};

        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) dq.pollLast();
            dq.offer(i);
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            if (i - k + 1 >= 0 && !dq.isEmpty()) ans[i - k + 1] = nums[dq.peekFirst()];
            System.out.println(i);
            System.out.println(dq);
            System.out.println(Arrays.toString(ans));
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
