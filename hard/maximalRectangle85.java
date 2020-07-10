import java.util.Arrays;

public class maximalRectangle85 {
    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }
        };
        maximalRectangle85 tmp = new maximalRectangle85();
        System.out.println(tmp.maximalRectangle(a));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] accMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            int c = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') c++;
                else if (matrix[i][j] == '0') c = 0;
                accMatrix[i][j] = c;
            }
        }
        int maxRec = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int width = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    width = Math.min(width, accMatrix[k][j]);
                    maxRec = Math.max(maxRec, (k - i + 1) * width);
                }
            }
        }

        System.out.println(Arrays.deepToString(accMatrix));
        return maxRec;
    }
}
