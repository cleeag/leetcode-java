import java.util.Arrays;

public class rotate48 {
    public static void main(String[] args) {
        int[][] m = new int[][]{{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        rotate48 tmp = new rotate48();
        tmp.rotate(m);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - i * 2 - 1; j++) {
                System.out.println(i + " " + j);
                int tmp = matrix[i + j][n - 1 - i];
                System.out.println(tmp);
                matrix[i + j][n - 1 - i] = matrix[i][i + j];
                matrix[i][i + j] = matrix[n - 1 - i - j][i];
                matrix[n - 1 - i - j][i] = matrix[n - 1 - i][n - 1 - i - j];
                matrix[n - 1 - i][n - 1 - i - j] = tmp;
            }
            System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
    }
}
