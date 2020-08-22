public class containsCycle1559 {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tracker = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tracker[i][j] == 0) {
                    if (dfs(grid, tracker, i, j, -1, -1)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] grid, int[][] tracker, int i, int j, int parentI, int parentJ) {
        tracker[i][j] = 1;
        System.out.println(i + " " + j);
        if (i - 1 >= 0) {
            if (tracker[i - 1][j] == 0 && grid[i - 1][j] == grid[i][j]) {
                if (dfs(grid, tracker, i - 1, j, i, j)) return true;
            } else if (tracker[i - 1][j] == 1 && grid[i - 1][j] == grid[i][j]&& i - 1 != parentI) {
                return true;
            }
        }
        if (i + 1 < grid.length) {
            if (tracker[i + 1][j] == 0 && grid[i + 1][j] == grid[i][j]) {
                if (dfs(grid, tracker, i + 1, j, i, j)) return true;
            } else if (tracker[i + 1][j] == 1 && grid[i + 1][j] == grid[i][j] && i + 1 != parentI) {
                return true;
            }
        }
        if (j - 1 >= 0) {
            if (tracker[i][j - 1] == 0 && grid[i][j - 1] == grid[i][j]) {
                if (dfs(grid, tracker, i, j - 1, i, j)) return true;
            } else if (tracker[i][j - 1] == 1 && grid[i][j - 1] == grid[i][j] && j - 1 != parentJ) {
                return true;
            }

        }
        if (j + 1 < grid[0].length) {
            if (tracker[i][j + 1] == 0 && grid[i][j + 1] == grid[i][j]) {
                if (dfs(grid, tracker, i, j + 1, i, j)) return true;
            } else if (tracker[i][j + 1] == 1 && grid[i][j + 1] == grid[i][j] && j + 1 != parentJ) {
                return true;
            }
        }
        return false;
    }
}
