public class maxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tracker = new int[m][n];
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || tracker[i][j] == 1) continue;
                area = Math.max(area, dfs(grid, tracker, i, j));
            }
        }
        return area;
    }

    public int dfs(int[][] grid, int[][] tracker, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || tracker[i][j] == 1 || grid[i][j] == 0) return 0;
        tracker[i][j] = 1;
        int[][] newPoints = new int[][]{{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
        int agg = 0;
        for (int[] newPoint : newPoints) {
            int nI = newPoint[0];
            int nJ = newPoint[1];
            agg += dfs(grid, tracker, nI, nJ);
        }
        return 1 + agg;
    }
}
