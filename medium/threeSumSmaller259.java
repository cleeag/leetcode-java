import java.util.Arrays;

public class threeSumSmaller259 {
    public static void main(String[] args) {
        int[] n = new int[]{-2, 0, 1, 3};
//        int[] n = new int[]{0};
        int t = 2;
//        int[] n = new int[]{1, 1, -2};
//        int t = 1;
//        int[] n = new int[]{2,0,0,2,-2};
//        int t = 2;
        threeSumSmaller259 tmp = new threeSumSmaller259();
        tmp.threeSumSmaller(n, t);
    }

    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int left = i+1, right = n-1;
            while (left < right){
                if (nums[i] + nums[left] + nums[right] < target){
                    count += right - left;
                    left++;
                } else right--;
            }
        }
        System.out.println(count);
        return count;
    }

    public int threeSumSmallerFUCK(int[] nums, int target) {
        int[] count = new int[201];
        int[] preCount = new int[201];
        for (int num : nums) count[100 + num]++;
        preCount[0] = count[0];
        for (int i = 1; i < count.length; i++) preCount[i] = preCount[i - 1] + count[i];
        int n = count.length;
        int i = 0, j = 0, k = n - 1;
        int ans = 0;
        while (j < n) {
            while (i < n && count[i] == 0) i++;
            while (k >= 0 && count[k] == 0) k--;
            if (i > j || k < j) {
                j++;
                while (j < n && count[j] == 0) j++;
                i = 0;
                k = n - 1;
                continue;
            }
            int sum = i + k + j - 300;
            if (sum < target) {
                if (i == j && i == k) {
                    int tmp = count[i];
                    ans += (tmp - 1) * (tmp - 2) * tmp / 6;
                } else if (i == j) {
                    ans += count[i] * (count[i] - 1) / 2 * (preCount[k] - preCount[j]);
                } else if (j == k) {
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                } else {
                    ans += count[i] * count[k] * (preCount[k] - preCount[j]);
                    ans += count[i] * count[j] * (count[j] - 1) / 2;
                }
                System.out.println((i - 100) + " " + (j - 100) + " " + (k - 100) + " " + ans);
                i++;
                while (i < n && count[i] == 0) i++;
            } else {
                k--;
                while (k >= 0 && count[k] == 0) k--;
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int threeSumSmallerSTUPID(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[201];
        for (int num : nums) count[100 + num]++;
        int i = 0, j = 0, k = nums.length - 1;
        int ans = 0;
        while (j < n) {
            if (i == j || j == k) {
                j++;
                i = 0;
                k = nums.length - 1;
                while (j < n && (j == 0 || nums[j] == nums[j - 1])) {
                    System.out.println(j);
                    j++;
                }
                continue;
            }
            int sum = nums[i] + nums[j] + nums[k];
            if (sum < target) {
                ans += count[100 + nums[i]] * count[100 + nums[j]] * count[100 + nums[k]];
                System.out.println(nums[i] + " " + nums[j] + " " + nums[k] + " " + ans);
                while (i == 0 || nums[i] == nums[i - 1]) {
                    System.out.println(i);
                    i++;
                }
            } else {
                while (k == n - 1 || nums[k] == nums[k + 1]) {
                    System.out.println(k);
                    k--;
                }
            }
            System.out.println(i + " " + j + " " + k + " " + ans);
        }
        System.out.println(ans);
        return ans;
    }
}
