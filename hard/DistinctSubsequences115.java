import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DistinctSubsequences115 {
    public static void main(String[] args){
        DistinctSubsequences115 tmp = new DistinctSubsequences115();
//        String S = "rabbbit", T = "rabbit";
        String S = "babgbag", T = "bag";
        tmp.numDistinct(S, T);
    }

    public int numDistinct(String s, String t) {
        if (s.length() == 0) return 0;
        else if (t.length() == 0) return 1;
        int[][] dp = new int[t.length()][s.length()];
        if (s.charAt(0) == t.charAt(0)) dp[0][0] = 1;
        else dp[0][0] = 0;
        for (int i = 1; i < s.length(); i++)
            if (s.charAt(i) == t.charAt(0)) dp[0][i] = dp[0][i - 1] + 1;
            else dp[0][i] = dp[0][i - 1];


        for (int i = 1; i < t.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[t.length()-1][s.length()-1];
    }
}
