import java.util.Arrays;

public class isMatch10 {
    public static void main(String[] args) {
//        String s = "aab";
//        String p = "c*a*b";
//        String s = "mississippi";
//        String p = "mis*is*p*.";

        String s = "aaab";
        String p = ".*";
//        String s = "aaa";
//        String p = "ab*a*c*a";
//        String s = "abcdede";
//        String p = "ab.*de";
//        String s = "";
//        String p = "c*c*";
        isMatch10 tmp = new isMatch10();
        tmp.isMatch(s, p);
    }

    public boolean isMatch(String s, String p) {
        int m = p.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        if (p.length() >= 2 && p.charAt(1) == '*') dp[2][0] = 1;
        for (int i = 1; i < m + 1; i++) {
            System.out.println(p.charAt(i - 1));
            System.out.println(p);
            if (i > 1 && p.charAt(i-1) == '*') dp[i][0] = dp[i-2][0];
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(i - 1) == '*') {
                    if (p.charAt(i - 2) == '.')
                        dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 2][j], Math.max(dp[i - 1][j], dp[i][j - 1])));
                    else if (p.charAt(i - 2) == s.charAt(j - 1)) {
                        if ((j > 1 && s.charAt(j - 1) == s.charAt(j - 2)))
                            dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 2][j], Math.max(dp[i - 1][j], dp[i][j - 1])));
                        else
                            dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 2][j], dp[i - 1][j]));
                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                } else if (p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(i - 1) != s.charAt(j - 1)) {
                        dp[i][j] = 0;
                    } else if (dp[i - 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }
            }
            System.out.println("   " + Arrays.toString(s.toCharArray()));
            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
        }
        return dp[m][n] == 1;
    }
}
