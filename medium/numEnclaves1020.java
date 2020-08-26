import java.util.Arrays;

public class numEnclaves1020 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        numEnclaves1020 tmp = new numEnclaves1020();
        tmp.numEnclaves(a);
    }

    public int numEnclaves(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] tracker = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tracker[i][j] == 0 && A[i][j] == 1 && (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                    stepOut(A, tracker, i, j);
                }
            }
            System.out.println(Arrays.deepToString(tracker).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tracker[i][j] == 0 && A[i][j] == 1){
                    ans++;
                }
            }
        }
        System.out.println(ans);
        return ans;
    }

    public void stepOut(int[][] A, int[][] tracker, int i, int j) {
        int m = A.length, n = A[0].length;
        tracker[i][j] = 2;
        int[][] newPoints = new int[][]{{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
        for (int[] newPoint : newPoints) {
            int nI = newPoint[0], nJ = newPoint[1];
            if (nI < 0 || nI >= m || nJ < 0 || nJ >= n || tracker[nI][nJ] != 0 || A[nI][nJ] == 0) continue;
            stepOut(A, tracker, nI, nJ);
        }
    }
}
