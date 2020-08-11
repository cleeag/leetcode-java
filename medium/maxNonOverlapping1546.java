import java.util.*;

public class maxNonOverlapping1546 {
    public static void main(String[] args) {
        int[] n = new int[]{-1, 3, 5, 1, 4, 2, -9};
        int target = 6;
//        int[] n = new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8};
//        int target = 10;
//        int[] n = new int[]{1, 1, 1, 1, 1};
//        int target = 2;
//        int[] n = new int[]{0, 0, 0};
//        int target = 0;
        maxNonOverlapping1546 tmp = new maxNonOverlapping1546();
        tmp.maxNonOverlapping(n, target);
    }

    public int maxNonOverlapping(int[] nums, int target) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0] == target ? 1 : 0;

        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        Map<Integer, List<Integer>> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            if (!hMap.containsKey(prefixSum[i + 1])) hMap.put(prefixSum[i + 1], new LinkedList<>());
            hMap.get(prefixSum[i + 1]).add(i + 1);
        }
        int front = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        if (hMap.containsKey(target)) {
            dp[0] = 1;
            front = hMap.get(target).get(0);
        }
        for (int i = 1; i < n + 1; i++) {
            List<Integer> tmpList = hMap.get(prefixSum[i] + target);
            if (tmpList == null) {
                dp[i] = dp[i - 1];
                continue;
            }

            for (Integer num : tmpList) {
                if (num > i) {
                    if (front == Integer.MAX_VALUE) {
                        dp[i] = 1;
                        front = num;
                    } else if (i >= front) {
                        dp[i] = dp[i - 1] + 1;
                        front = num;
                    } else if (num < front) {
                        dp[i] = dp[i - 1];
                        front = num;
                    }
                    break;
                }
            }
            if (dp[i] == 0) dp[i] = dp[i - 1];
//            System.out.println(front + " " + prefixSum[front]);
//            System.out.println(Arrays.toString(dp));
        }
//        System.out.println(hMap);
//        System.out.println(Arrays.toString(prefixSum));
        return dp[dp.length - 1];
    }
}
