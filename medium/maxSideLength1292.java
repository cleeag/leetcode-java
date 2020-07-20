import java.util.Arrays;

public class maxSideLength1292 {
    public static void main(String[] args) {
//        int[][] mat = new int[][]{{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
//        int threshold = 4;
        int[][] mat = {{1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}};
        int threshold = 6;
        maxSideLength1292 tmp = new maxSideLength1292();
        System.out.println(tmp.maxSideLength(mat, threshold));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length, maxVal = Integer.MIN_VALUE;
        int[][] agg = new int[m][n];
        agg[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) agg[i][0] = agg[i - 1][0] + mat[i][0];
        for (int i = 1; i < n; i++) agg[0][i] = agg[0][i - 1] + mat[0][i];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                agg[i][j] = agg[i - 1][j] + agg[i][j - 1] - agg[i - 1][j - 1] + mat[i][j];
            }
        }
        int k = Math.min(m, n);
        for (; k >= 0; k--) {
            for (int i = 0; i + k < m; i++) {
                for (int j = 0; j + k < n; j++) {
                    int val;
                    if (i == 0 && j == 0) val = agg[i + k][j + k];
                    else if (i == 0) val = agg[i + k][j + k] - agg[i + k][j - 1];
                    else if (j == 0) val = agg[i + k][j + k] - agg[i - 1][j + k];
                    else val = agg[i + k][j + k] - agg[i - 1][j + k] - agg[i + k][j - 1] + agg[i - 1][j - 1];
                    System.out.println(val);
                    if (val <= threshold) return k+1;
                }
            }
        }
        System.out.println(Arrays.deepToString(agg));
        return 0;
    }
}
