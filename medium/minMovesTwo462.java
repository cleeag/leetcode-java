import java.util.Arrays;

public class minMovesTwo462 {
    public static void main(String[] args) {
        minMovesTwo462 tmp = new minMovesTwo462();
        int[] n = new int[]{4, 1, 8, 3, 5, 5};
        tmp.minMoves2(n);
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = 0;
        if (nums.length % 2 == 0) {
            int mid1 = nums[nums.length / 2 - 1];
            int mid2 = nums[nums.length / 2 - 1];
            if (mid1 == mid2) mid = mid1;
            else {
                int mid1Count = 0, mid2Count = 0;
                for (int num : nums) {
                    if (num == mid1) mid1Count++;
                    if (num == mid1) mid2Count++;
                }
                if (mid1Count > mid2Count) mid = mid1;
                else mid = mid2;
            }
        } else mid = nums[nums.length / 2];

        int moves = 0;
        int i = 0;
        while (i < nums.length / 2) {
            moves += mid - nums[i] + nums[nums.length - 1 - i] - mid;
            i++;
        }
//        if (nums.length % 2 == 0) moves += nums[nums.length/2] - mid;
        System.out.println(Arrays.toString(nums));
        System.out.println(mid);
        System.out.println(moves);
        return moves;
    }
}
