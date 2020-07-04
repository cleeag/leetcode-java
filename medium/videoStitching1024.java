import java.util.Arrays;
import java.util.Comparator;

public class videoStitching1024 {
    public static void main(String[] args) {
//        int[][] c = new int[][] {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int t = 10;
//        int[][] c = new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7},
//                {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}};
//        int t = 9;

        int[][] c = new int[][]{{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}};
        int t = 5;
        videoStitching1024 tmp = new videoStitching1024();
        tmp.videoStitching(c, t);
    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        if (clips[0][0] > 0) return -1;

        int clipsNum = clips.length;
        int[] dp = new int[clipsNum];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;
        System.out.println(Arrays.deepToString(clips));

        int finalMin = Integer.MAX_VALUE;
        for (int i = 0; i < clipsNum; i++) {
            if (clips[i][0] == 0) {
                dp[i] = 1;
                if (clips[i][1] >= T) return 1;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (clips[j][1] >= clips[i][0])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
            if (clips[i][1] >= T) finalMin = Math.min(finalMin, dp[i]);
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(finalMin);
        return finalMin == Integer.MAX_VALUE ? -1 : finalMin;
    }

}
