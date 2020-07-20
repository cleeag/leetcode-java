import java.util.LinkedList;
import java.util.List;

public class findDiagonalOrder498 {
    public static void main(String[] args) {
        int[][] m = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        findDiagonalOrder498 tmp = new findDiagonalOrder498();
        tmp.findDiagonalOrder(m);
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        List<Integer> ans = new LinkedList<>();
        int i = 0, j = 0;
        int flip = 0;
        while (true) {
            System.out.println(i + " " + j);
            ans.add(matrix[i][j]);
            if (i == m - 1 && j == n - 1) break;
            if (flip % 2 == 0) {
                if (i - 1 < 0 && j + 1 < n) {
                    j++;
                    flip++;
                }
                else if (j + 1 >= n) {
                    i++;
                    flip++;
                }
                else {
                    i--;
                    j++;
                }
            } else {
                if (j - 1 < 0 && i + 1 < m) {
                    i++;
                    flip++;
                }
                else if (i + 1 >= m) {
                    j++;
                    flip++;
                }
                else {
                    i++;
                    j--;
                }
            }
        }

        int[] res = new int[ans.size()];
        int k = 0;
        for (Integer a : ans) res[k++] = a;

        return res;
    }
}
