public class generateMatrix59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        String dir = "r";
        for (int k = 0; k < Math.pow(n, 2); k++) {
            ans[i][j] = k + 1;
            System.out.println(i + " " + j);
            System.out.println(ans[i][j]);
            switch (dir) {
                case "r":
                    if (j == n - 1 || ans[i][j + 1] != 0) {
                        dir = "d";
                        i++;
                    } else j++;
                    break;
                case "d":
                    if (i == n - 1 || ans[i + 1][j] != 0) {
                        dir = "l";
                        j--;
                    } else i++;
                    break;
                case "l":
                    if (j == 0 || ans[i][j - 1] != 0) {
                        dir = "u";
                        i--;
                    } else j--;
                    break;
                case "u":
                    if (i == 0 || ans[i - 1][j] != 0) {
                        dir = "r";
                        j++;
                    } else i--;
                    break;
            }
        }
        return ans;
    }
}
