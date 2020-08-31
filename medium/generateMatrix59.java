public class generateMatrix59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[0][0];
        int[][] ans = new int[n][n];
        int count = 1;
        int i = 0, j = 0, k = 0;
        while (count <= n * n) {
            ans[i][j] = count;
            int[][] dir = new int[][]{{i, j + 1}, {i + 1, j}, {i, j - 1}, {i - 1, j}};
            i = dir[k][0];
            j = dir[k][1];
            if (i < 0 || i >= n || j < 0 || j >= n || ans[i][j] != 0) {
                k++;
                if (k == 4) k = 0;
                i = dir[k][0];
                j = dir[k][1];
            }
            System.out.println(k + " " + i + " " + j);
            System.out.println(Arrays.deepToString(ans).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
            count++;
        }
        System.out.println(Arrays.deepToString(ans).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
        return ans;
    }

    public int[][] generateMatrix2(int n) {
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
