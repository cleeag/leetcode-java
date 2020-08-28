import java.util.Arrays;

public class searchMatrix240 {
    public static void main(String[] args) {
//        int[][] m = new int[][]{
//                {1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
////
        int[][] m = {{3, 3, 8, 13, 13, 18}, {4, 5, 11, 13, 18, 20}, {9, 9, 14, 15, 23, 23}, {13, 18, 22, 22, 25, 27}, {18, 22, 23, 28, 30, 33}, {21, 25, 28, 30, 35, 35}, {24, 25, 33, 36, 37, 40}};

        System.out.println(Arrays.deepToString(m).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
        searchMatrix240 tmp = new searchMatrix240();
        System.out.println(tmp.searchMatrix(m, 21));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0;
        while (row < m - 1 && matrix[row][n - 1] < target) row++;

        int c = BS(matrix[row], target);
        if (c == -1) return true;
        int[] column = new int[m];
        for (int i = 0; i < m; i++) column[i] = matrix[i][c];
        int row2 = BS(column, target);
        if (row2 == -1) return true;
        if (matrix[row2][c] == target) return true;
        System.out.println(c + " " + row2);

        int case1 = BS(Arrays.copyOfRange(matrix[row2], c, n), target);
        if (matrix[row2][case1] == target) return true;
        if (row2+1 < m){
            int case2 = BS(Arrays.copyOfRange(matrix[row2+1],0, c), target);
            if (matrix[row2 + 1][case2] == target) return true;
        }
        return false;
    }

    public int BS(int[] arr, int target){
        int lo = 0, hi = arr.length - 1;
        while (lo < hi - 1) {
            System.out.println("lo: " + " " + lo + " hi: " + " " + hi);
            int mid = (lo + hi) / 2;
            if (arr[mid] > target) hi = mid;
            else lo = mid;
        }
        System.out.println();
        if (arr[hi] == target || arr[lo] == target) return -1;
        if (arr[hi] < target) return hi;
        return lo;
    }
}
