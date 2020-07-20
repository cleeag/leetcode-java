import java.util.Arrays;

public class longestPalindromeSubseq516 {
    public static void main(String[] args) {
        String s = "bbbab";
//        String s = "cbbd";
        longestPalindromeSubseq516 tmp = new longestPalindromeSubseq516();
        tmp.longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l;
                if (j >= n) continue;
                if (s.charAt(i) == s.charAt(j)){
                    if (l == 1) dp[i][j] = 2;
                    else dp[i][j] = dp[i+1][j-1] + 2;
                }
                else dp[i][j] = Math.max(dp[i][j-1], dp[i + 1][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n-1];
    }
}
