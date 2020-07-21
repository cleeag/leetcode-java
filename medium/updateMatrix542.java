import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix542 {
    public static void main(String[] args) {
//        int[][] m = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] m = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        updateMatrix542 tmp = new updateMatrix542();
        tmp.updateMatrix(m);
//        tmp.bfs(m, 9, 0);
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) return new int[0][0];
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                if (i-1 >=0 && matrix[i-1][j] == 0) res[i][j] = 1;
                else if (i+1 <m && matrix[i+1][j] == 0) res[i][j] = 1;
                else if (j-1 >=0 && matrix[i][j-1] == 0) res[i][j] = 1;
                else if (j+1 <n && matrix[i][j+1] == 0) res[i][j] = 1;
                else res[i][j] = bfs(matrix, i, j);
            }
        }
        System.out.println(Arrays.deepToString(res));
        return res;
    }

    public int bfs(int[][] matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        int[][] been = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int distance = 0;
        int qSize = q.size();
        while (!q.isEmpty()) {
            for (int k = 0; k < qSize; k++) {
                int[] curCord = q.poll();
//                System.out.println(Arrays.toString(curCord));
                been[curCord[0]][curCord[1]] = 1;
                if (matrix[curCord[0]][curCord[1]] == 0) return distance;
                if (curCord[0] - 1 >= 0 && been[curCord[0] - 1][curCord[1]] == 0) {
                    if (matrix[curCord[0] - 1][curCord[1]] == 0) return distance + 1;
                    q.add(new int[]{curCord[0] - 1, curCord[1]});
                    been[curCord[0] - 1][curCord[1]] = 1;
                }
                if (curCord[0] + 1 < m && been[curCord[0] + 1][curCord[1]] == 0) {
                    if (matrix[curCord[0] + 1][curCord[1]] == 0) return distance + 1;
                    q.add(new int[]{curCord[0] + 1, curCord[1]});
                    been[curCord[0] + 1][curCord[1]] = 1;
                }
                if (curCord[1] - 1 >= 0 && been[curCord[0]][curCord[1] - 1] == 0) {
                    if (matrix[curCord[0]][curCord[1] - 1] == 0) return distance + 1;
                    q.add(new int[]{curCord[0], curCord[1] - 1});
                    been[curCord[0]][curCord[1] - 1] = 1;
                }
                if (curCord[1] + 1 < n && been[curCord[0]][curCord[1] + 1] == 0) {
                    if (matrix[curCord[0]][curCord[1] + 1] == 0) return distance + 1;
                    q.add(new int[]{curCord[0], curCord[1] + 1});
                    been[curCord[0]][curCord[1] + 1] = 1;
                }
            }
            qSize = q.size();
            distance += 1;
        }
        return distance;
    }
}
