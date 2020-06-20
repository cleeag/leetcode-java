import java.util.*;

public class getMaximumGold1219 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        getMaximumGold1219 tmp = new getMaximumGold1219();
        tmp.getMaximumGold(grid);
    }

    public int getMaximumGold(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(grid, m, n, i, j));
            }
        }

        System.out.println(ans);
        return 0;
    }

    public int dfs(int[][] grid, int m, int n, int i, int j) {
        System.out.println(i + " " + j);
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) return 0;
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        int origin = grid[i][j];
        int maxGold = 0;
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++)
                maxGold = Math.max(maxGold, dfs(grid, m, n, i + DIR[k], j + DIR[k + 1]));
        grid[i][j] = origin;
        return origin + maxGold;
    }
}
