import java.util.Arrays;

public class numSubmat1504 {
    public int numSubmat(int[][] mat) {


        int m = mat.length, n = mat[0].length;
        int[][] pre = new int[m][n];
        for (int i = 0; i < m; i++) {
            int c = 0;
            for (int j = n-1; j >=0; j--) {
                if (mat[i][j] != 0) c++;
                else c = 0;
                pre[i][j] = c;
            }
        }
        System.out.println(Arrays.deepToString(pre));
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    x = Math.min(x, pre[k][j]);
                    res += x;
                }
            }
        }
        return res;
    }
}
