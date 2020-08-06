import java.util.Arrays;

public class minimumDeleteSum712 {
    public static void main(String[] args) {
//        String s1 = "sea";
//        String s2 = "eat";
        String s1 = "delete";
        String s2 = "leet";
        minimumDeleteSum712 tmp = new minimumDeleteSum712();
        System.out.println(tmp.minimumDeleteSum(s1, s2));
    }
    public int minimumDeleteSum(String s1, String s2) {

        int[] asc1 = new int[s1.length()];
        int[] asc2 = new int[s2.length()];
        int asc1Value = 0, asc2Value = 0;
        for (int i = 0; i < s1.length(); i++) {
            asc1[i] = (int) s1.charAt(i);
            asc1Value += asc1[i];
        }
        for (int i = 0; i < s2.length(); i++){
            asc2[i] = (int) s2.charAt(i);
            asc2Value += asc2[i];
        }
        int m = asc1.length, n = asc2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (asc1[i - 1] == asc2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + asc1[i-1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
//            System.out.println(Arrays.deepToString(dp));
        }
        return asc1Value + asc2Value - 2* dp[m][n];
    }
}
