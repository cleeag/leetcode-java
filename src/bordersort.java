import java.util.Arrays;

public class bordersort {
    public static void main(String[] args) {
//        int[][] m = new int[][]{
//                {9, 7, 4, 5},
//                {1, 6, 2, -6},
//                {12, 20, 2, 0},
//                {-5, -6, 7, -2}};
        int[][] m = new int[][]{
                {9, 7, 4, 5, 2},
                {1, 6, 2, -6, 4},
                {12, 20, 2, 0, 5},
                {-5, -6, 7, -2, 1},
                {-5, -6, 7, -2, 1}};
        bordersort tmp = new bordersort();
        tmp.borderSort(m);
    }

    int[][] borderSort(int[][] matrix) {
        int n = matrix.length;
        int[][] tracker = new int[n][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < (n + 1) / 2; k++) {
            int nums = (n - k * 2) * 4 - 4;
            if (n - k * 2 == 1) nums = 1;
            int[] level = new int[nums];
            nums--;
            int i = k, j = k;
            int dir = 0;
            while (nums >= 0) {
                level[nums--] = matrix[i][j];
                tracker[i][j] = 1;
                if (i + directions[dir][0] < 0 || i + directions[dir][0] >= n ||
                        j + directions[dir][1] < 0 || j + directions[dir][1] >= n ||
                        tracker[i + directions[dir][0]][j + directions[dir][1]] != 0) dir++;
                if (dir == 4) dir = 0;
                i += directions[dir][0];
                j += directions[dir][1];
            }
            Arrays.sort(level);
            i = k;
            j = k;
            dir = 0;
            int count = 0;
            while (count < level.length) {
                matrix[i][j] =level[count++];
                tracker[i][j] = 2;
                if (i + directions[dir][0] < 0 || i + directions[dir][0] >= n ||
                        j + directions[dir][1] < 0 || j + directions[dir][1] >= n ||
                        tracker[i + directions[dir][0]][j + directions[dir][1]] == 2) dir++;
                if (dir == 4) dir = 0;
                i += directions[dir][0];
                j += directions[dir][1];
            }
            System.out.println(Arrays.toString(level));
            System.out.println(Arrays.deepToString(matrix).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
            System.out.println(Arrays.deepToString(tracker).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");

        }
        return matrix;
    }
}
