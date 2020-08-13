public class maxIncreaseKeepingSkyline807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] horMax= new int[m], verMax = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                horMax[i] = Math.max(horMax[i], grid[i][j]);
                verMax[j] = Math.max(verMax[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += Math.min(horMax[i], verMax[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
