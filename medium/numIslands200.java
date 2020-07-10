import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class numIslands200 {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '0', '0', '0' },
//                {'1', '1', '0', '0', '0' },
//                {'0', '0', '1', '0', '0' },
//                {'0', '0', '0', '1', '1' }
//        };

        char[][] grid = {{'1', '1', '1' }, {'0', '1', '0' }, {'1', '1', '1' }};
        numIslands200 tmp = new numIslands200();
        System.out.println(tmp.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] been = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && been[i][j] == 0) {
                    bfs(grid, been, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int[][] been, int i, int j) {
        System.out.println(i + " " + j);
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] curCord = q.poll();
            int curX = curCord[0], curY = curCord[1];
            been[curX][curY] = 1;
            if (curX + 1 < m && grid[curX + 1][curY] == '1' && been[curX + 1][curY] == 0) {
                q.add(new int[]{curX + 1, curY});
                been[curX + 1][curY] = 1;
            }
            if (curY + 1 < n && grid[curX][curY + 1] == '1' && been[curX][curY + 1] == 0) {
                q.add(new int[]{curX, curY + 1});
                been[curX][curY + 1] = 1;
            }
            if (curX - 1 >= 0 && grid[curX - 1][curY] == '1' && been[curX - 1][curY] == 0) {
                q.add(new int[]{curX - 1, curY});
                been[curX - 1][curY] = 1;
            }
            if (curY - 1 >= 0 && grid[curX][curY - 1] == '1' && been[curX][curY - 1] == 0) {
                q.add(new int[]{curX, curY - 1});
                been[curX][curY - 1] = 1;
            }
        }
        System.out.println(Arrays.deepToString(been));
    }

}
