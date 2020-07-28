public class arrayNesting565 {
    public static void main(String[] args) {
        int[] n = new int[] {5,4,0,3,1,6,2};
        arrayNesting565 tmp = new arrayNesting565();
        tmp.arrayNesting(n);
    }
    public int arrayNesting(int[] nums) {
        if (nums.length == 0) return 0;
        int[] seen = new int[nums.length];
        int longest = 1, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            longest = 1;
            seen[i] = 1;
            int cur = nums[i];
            while (seen[cur] == 0){
                longest++;
                seen[cur] = 1;
                cur = nums[cur];
            }
            ans = Math.max(ans, longest);
        }
        System.out.println(ans);
        return ans;
    }
}
