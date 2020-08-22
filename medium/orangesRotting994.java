import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class orangesRotting994 {
    public static void main(String[] args) {
//        int[][] g = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int[][] g = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] g = new int[][]{{2, 0}, {0, 1}};
        orangesRotting994 tmp = new orangesRotting994();
        System.out.println(tmp.orangesRotting(g));
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] tracker = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        int time = 0;
        while (fresh > 0 && q.size() > 0) {
            int qSize = q.size();
            System.out.println(time + " " + fresh);
            for (int k = 0; k < qSize; k++) {
                int[] node = q.poll();
                System.out.println(Arrays.toString(node));
                int i = node[0], j = node[1];
                tracker[i][j] = 1;
                if (grid[i][j] == 1) fresh--;
                if (i - 1 >= 0 && tracker[i - 1][j] == 0 && grid[i - 1][j] != 0) {
                    q.add(new int[]{i - 1, j});
                    tracker[i - 1][j] = 1;
                }
                if (i + 1 < m && tracker[i + 1][j] == 0 && grid[i + 1][j] != 0) {
                    q.add(new int[]{i + 1, j});
                    tracker[i + 1][j] = 1;
                }
                if (j - 1 >= 0 && tracker[i][j - 1] == 0 && grid[i][j - 1] != 0) {
                    q.add(new int[]{i, j - 1});
                    tracker[i][j - 1] = 1;
                }
                if (j + 1 < n && tracker[i][j + 1] == 0 && grid[i][j + 1] != 0) {
                    q.add(new int[]{i, j + 1});
                    tracker[i][j + 1] = 1;
                }
            }
            time++;
        }
        return fresh == 0 ? Math.max(0, time - 1) : -1;
    }
}
