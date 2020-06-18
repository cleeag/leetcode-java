import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import java.awt.*;
import java.util.Arrays;

public class maximalSquare221 {
    public static void main(String[] args) {
        char[][] m = new char[][]{{'0','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        maximalSquare221 tmp = new maximalSquare221();
        tmp.maximalSquare(m);
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) dp[0][i] = Character.getNumericValue(matrix[0][i]);
        for (int i = 1; i < matrix.length; i++) dp[i][0] = Character.getNumericValue(matrix[i][0]);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1' && dp[i - 1][j - 1] != 0) {
                    int height = 1, width = 1;
                    for (; height < dp[i - 1][j - 1] + 1; height++)
                        if (matrix[i - height][j] == '0') {
                            break;
                        }
                    for (; width < dp[i - 1][j - 1] + 1; width++)
                        if (matrix[i][j - width] == '0') {
                            break;
                        }
                    dp[i][j] = Math.min(height, width);
                } else if (matrix[i][j] == '1') dp[i][j] = 1;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(dp));
        int maxSize = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dp[i][j] > maxSize) maxSize = dp[i][j];
            }
        }
        return maxSize*maxSize;
    }
}
