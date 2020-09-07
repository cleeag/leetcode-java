public class minCost1578 {
    public static void main(String[] args) {
        String s = "aaabbbabbbb";
        int[] c = new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        minCost1578 tmp = new minCost1578();
        tmp.minCost(s, c);
    }

    public int minCost(String s, int[] cost) {
        int prev = -1;
        int n = cost.length;
        int ans = 0;
        int j = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if (prev == -1) prev = cost[i-1];
                ans += Math.min(cost[i], prev);
                prev = Math.max(cost[i], prev);
                System.out.println(ans);
            }
            else prev = -1;
        }
        return ans;
    }
}
