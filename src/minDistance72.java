import java.util.Arrays;

public class minDistance72 {
    public static void main(String[] args) {
//        String w1 = "horse";
//        String w2 = "ros";
//        String w1 = "intention";
//        String w2 = "execution";
        String w1 = "pneumonoultramicroscopicsilicovolcanoconiosis";
        String w2 = "ultramicroscopically";
        minDistance72 tmp = new minDistance72();
        tmp.minDistance(w1, w2);
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) dp[i][0] = dp[i - 1][0] + 1;
        for (int j = 1; j < n + 1; j++) dp[0][j] = dp[0][j - 1] + 1;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            System.out.println();
        }
        return dp[m][n];
    }
}
