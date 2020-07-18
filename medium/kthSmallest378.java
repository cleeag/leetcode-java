import java.util.Arrays;

public class kthSmallest378 {
    public static void main(String[] args) {
//        int[][] mat = new int[][]{
//                {1, 5, 9},
//                {10, 11, 13},
//                {12, 13, 15}
//        };
        int[][] mat = new int[][]{
                {1, 2},{2,3}};
        int k = 4;
        kthSmallest378 tmp = new kthSmallest378();
        tmp.kthSmallest(mat, k);
    }

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;
        int dim = matrix.length;
        int[] pointers = new int[dim];
        int latest = 0;
        while (k > 0) {
            int minima = Integer.MAX_VALUE;
            for (int i = 0; i < dim; i++) {
                if (pointers[i] == dim) continue;
                minima = Math.min(minima, matrix[i][pointers[i]]);
            }
            for (int i = 0; i < dim; i++) {
                if (pointers[i] == dim) continue;
                if (minima == matrix[i][pointers[i]]) {
                    pointers[i]++;
                    latest = minima;
                    break;
                }
            }
            k--;
            System.out.println(Arrays.toString(pointers));
        }
        System.out.println(latest);
        return latest;
    }
}
