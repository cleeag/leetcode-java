import java.util.Arrays;
import java.util.Stack;

public class minCut132 {
    public static void main(String[] args) {
//        String s = "aabcdcbb";
//        String s = "aaa";
//        String s = "abb";
        String s = "aab";
        minCut132 tmp = new minCut132();
        tmp.minCut(s);
    }

    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l;
                if (j >= s.length()) break;
                if (i == j) isPal[i][j] = true;
                else if (i + 1 == j) {
                    isPal[i][j] = s.charAt(i) == s.charAt(j);
                } else if (s.charAt(i) == s.charAt(j)) {
                    isPal[i][j] = isPal[i + 1][j - 1];
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            if (isPal[0][i]) dp[i] = 0;
            else dp[i] = dp[i - 1] + 1;
            for (int j = 1; j < i; j++) {
                System.out.println(j + " " + i + " " + isPal[j][i]);
                if (isPal[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        System.out.println(s);
        System.out.println(Arrays.deepToString(isPal).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
