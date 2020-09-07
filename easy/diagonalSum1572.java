public class diagonalSum1572 {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}

        };
        diagonalSum1572 tmp = new diagonalSum1572();
        tmp.diagonalSum(m);
    }
    public int diagonalSum(int[][] mat) {
        if (mat.length == 0) return 0;
        int m = mat.length, n = mat[0].length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][i];
            if (i == n - 1 - i) {
                continue;
            }
            sum += mat[i][n - 1 - i];
        }
        return sum;
    }
}
