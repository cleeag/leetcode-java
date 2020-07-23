public class findCircleNum547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0) return 0;
        int circles = 0;
        int n = M.length;
        int[] seen = new int[n];
        for (int i = 0; i < n; i++) {
            if (seen[i] == 0) {
                seen[i] = 1;
                circles += dfs(M, seen, i);
            }
        }
        return circles;
    }

    public int dfs(int[][] M, int[] seen, int i) {
        int n = M.length;
        seen[i] = 1;
        int circle = 0;
        for (int k = 0; k < n; k++) {
            if (M[i][k] == 1) circle = 1;
            if (k != i && M[i][k] == 1 && seen[k] == 0) {
                dfs(M, seen, k);
            }
        }
        return circle;
    }
}
