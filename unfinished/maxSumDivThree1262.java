public class maxSumDivThree1262 {
    public int maxSumDivThree(int[] nums) {
        int res2min = 4, res1min = 4;
        int sum = 0;
        for (int num : nums) {
            if (sum == 0) sum += num;
            else if (num % 3 == 1){
                if (res1min > num)
            }

        }

    }
}
