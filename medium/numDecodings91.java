import java.util.Arrays;

public class numDecodings91 {
    public static void main(String[] args) {
///        String s = "17";
        String s = "01";
//        String s = "226";
        numDecodings91 tmp = new numDecodings91();
        System.out.println(tmp.numDecodings(s));

    }

    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        else if (s.length() == 1) return (Character.isDigit(s.charAt(0)) && s.charAt(0) - '0' > 0) ? 1 : 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (Character.isDigit(s.charAt(0)) && s.charAt(0) - '0' > 0) dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar - '0' >= 1 && Character.isDigit(curChar)) dp[i + 1] += dp[i];
            char prevChar = s.charAt(i - 1);
            if (prevChar != '0' && (prevChar - '0' == 1 && Character.isDigit(curChar)) ||
                    (prevChar - '0' == 2 && curChar - '0' >= 0 && curChar - '0' <= 6)) dp[i + 1] += dp[i - 1];

            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }

    public int numDecodingsDFS(String s) {
        return dfs(s, 0);
    }

    public int dfs(String s, int idx) {
        System.out.println(idx);
        if (idx == s.length()) return 1;

        int res = 0;
        char curChar = s.charAt(idx);
        if (curChar - '0' >= 1 && curChar - '0' <= 26) res += dfs(s, idx + 1);
        if (idx < s.length() - 1) {
            char nextChar = s.charAt(idx + 1);
            if ((curChar - '0' == 1 && Character.isDigit(nextChar)) ||
                    (curChar - '0' == 2 && nextChar - '0' >= 0 && nextChar - '0' <= 6))
                res += dfs(s, idx + 2);
        }
        return res;
    }
}
