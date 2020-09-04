import java.util.HashMap;
import java.util.Map;

public class knightProbability688 {
    public static void main(String[] args) {
        String code = 3 + " " + 2;
        System.out.println(code);

    }

    double[][][] dp;
    public double knightProbability(int N, int K, int r, int c) {
        dp = new double[N][N][K + 1];
        return find(N, K, r, c);
    }

    public double find(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        else if (K == 0) return 1;
        int[][] newPoints = new int[][]{
                {r + 2, c + 1}, {r + 2, c - 1},
                {r + 1, c + 2}, {r + 1, c - 2},
                {r - 2, c + 1}, {r - 2, c - 1},
                {r - 1, c + 2}, {r - 1, c - 2}};
        if (dp[r][c][K] != 0) return dp[r][c][K];
        double sum = 0;
        for (int[] newPoint : newPoints) {
            sum += find(N, K - 1, newPoint[0], newPoint[1]);
        }
        sum /= 8;
        System.out.println( r + " " + c + " " + K);
        System.out.println(dp[0][0].length);
        dp[r][c][K] = sum;
        return sum;
    }


    Map<String, Double> hMap = new HashMap<>();
    public double knightProbabilitySLOW(int N, int K, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N) return 0;
        else if (K == 0) return 1;
        int[][] newPoints = new int[][]{
                {r + 2, c + 1}, {r + 2, c - 1},
                {r + 1, c + 2}, {r + 1, c - 2},
                {r - 2, c + 1}, {r - 2, c - 1},
                {r - 1, c + 2}, {r - 1, c - 2}};
        String code = r + " " + c + " " + K;
        if (hMap.containsKey(code)) return hMap.get(code);
        double sum = 0;
        for (int[] newPoint : newPoints) {
            sum += knightProbability(N, K - 1, newPoint[0], newPoint[1]);
        }
        sum /= 8;
        hMap.put(code, sum);
        return sum;
    }

}
