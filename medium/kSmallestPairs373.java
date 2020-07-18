import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class kSmallestPairs373 {
    public static void main(String[] args) {
//        int[] nums1 = {1,7,11}, nums2 = {2,4,6};
//        int[] nums1 = {1,3, 5,11}, nums2 = {2,4,6, 7};
        int[] nums1 = {1,1,2}, nums2 = {1, 2,3};
        int k = 10;

        kSmallestPairs373 tmp = new kSmallestPairs373();
        tmp.kSmallestPairs(nums1, nums2, k);
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        int[] nums2Pointer = new int[nums2.length];
        while (k > 0) {
            boolean end = true;
            int minima = Integer.MAX_VALUE;
            for (int i = 0; i < nums2.length; i++) {
                if (nums2Pointer[i] == nums1.length) continue;
                else if (i > 0 && nums2Pointer[i] == 0 && nums2Pointer[i-1] == 0) break;
                else minima = Math.min(minima, nums1[nums2Pointer[i]] + nums2[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (nums2Pointer[i] == nums1.length) continue;
                if (minima == nums1[nums2Pointer[i]] + nums2[i]){
                    ans.add(new LinkedList<>(Arrays.asList(nums1[nums2Pointer[i]], nums2[i])));
                    nums2Pointer[i]++;
                    k--;
                    end = false;
                    break;
                }
            }
            if (end) break;
            System.out.println(ans);
            System.out.println(Arrays.toString(nums2Pointer));
        }
        System.out.println(ans);
        return ans;
    }
}
