public class longestArithSeqLength1027 {
    public static void main(String[] args) {
        longestArithSeqLength1027 tmp = new longestArithSeqLength1027();
    }

    public int longestArithSeqLength(int[] A) {
        int[][] dp = new int[A.length][2001];
        int longest = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 1000;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                longest = Math.max(longest, dp[i][diff]);
            }
        }
        return longest + 1;
    }
}
