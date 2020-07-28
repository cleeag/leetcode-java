import java.util.Arrays;

public class triangleNumber611 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2, 2, 3, 4};
        int[] nums = new int[]{1, 1, 3, 4};
        triangleNumber611 tmp = new triangleNumber611();
        tmp.triangleNumber(nums);
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length-1; i >=2; i--) {
            int l = 0, r = i-1;
            while (l < r){
                if (nums[l] + nums[r] > nums[i]){
                    ans += r-l;
                    r--;
                } else l++;
            }
        }
        return ans;
    }

    public int triangleNumberLMFAO(int[] nums) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        if (nums[nums.length - 1] == 0) return 0;
        int ans = 0;
        int l = nums.length - 1;
        int lLength = 1, mLength = 1, sLength = 1;
        while (l > 0 && nums[l] == nums[l - 1]) {
            l--;
            lLength++;
        }
        if (lLength >= 3) ans += lLength * (lLength - 1) * (lLength - 2) / 6;
        int m = l - 1, s = 0;

        while (l > 0 && nums[m] >= nums[s]) {
            System.out.println(s + " " + m + " " + l);
            if (nums[m] == nums[s] && nums[m] + nums[s] > nums[l]) {
                ans += lLength * (m - s) * (m - s + 1) / 2;
                break;
            }
            while (m > 0 && nums[m] == nums[m - 1]) {
                m--;
                mLength++;
            }
            while (s < nums.length && nums[s] == nums[s + 1]) {
                s++;
                sLength++;
            }
            if (nums[m] + nums[s] > nums[l]) {
                ans += lLength * mLength * (sLength + m - s - 1);
                m--;
                mLength = 1;
            } else {
                s++;
                sLength = 1;
            }
            if (m == s) {
                if (nums[s] + nums[m] > nums[l]) {
                    if (mLength > 1) ans += lLength * (mLength - 1) * mLength / 2;
                    else if (sLength > 1) ans += lLength * (sLength - 1) * sLength / 2;
                }
                l--;
                lLength = 1;
                while (nums[l] == nums[l - 1]) {
                    l--;
                    lLength++;
                }
                m = l - 1;
                s = 0;
            }
            System.out.println(ans);
        }
        System.out.println(ans);
        return ans;
    }
}
