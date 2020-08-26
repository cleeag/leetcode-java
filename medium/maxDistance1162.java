import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maxDistance1162 {
    public static void main(String[] args) {
//        int[][] g = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        int[][] g = new int[][]{{1,0,0,0,0,1,0,0,0,1},{1,1,0,1,1,1,0,1,1,0},{0,1,1,0,1,0,0,1,0,0},{1,0,1,0,1,0,0,0,0,0},{0,1,0,0,0,1,1,0,1,1},{0,0,1,0,0,1,0,1,0,1},{0,0,0,1,1,1,1,0,0,1},{0,1,0,0,1,0,0,1,0,0},{0,0,0,0,0,1,1,1,0,0},{1,1,0,1,1,1,1,1,0,0}};
        maxDistance1162 tmp = new maxDistance1162();
        System.out.println(tmp.maxDistance(g));
    }
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] tracker = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(tracker[i], -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    tracker[i][j] = 0;
                }
            }
        }
        if (q.size() == 0 || q.size() == m * n) return -1;

        int dist = 1;
        int qSize = q.size();
        int maxDist = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < qSize; i++) {
                int[] curPoint = q.poll();
                int cI = curPoint[0], cJ = curPoint[1];
//                System.out.println(cI + " " + cJ);
                int[][] newPoints = new int[][]{{cI + 1, cJ}, {cI - 1, cJ}, {cI, cJ + 1}, {cI, cJ - 1}};
                for (int[] newPoint : newPoints) {
                    int nI = newPoint[0], nJ = newPoint[1];
                    if (nI >= 0 && nI < m && nJ >= 0 && nJ < n && tracker[nI][nJ] == -1) {
//                        System.out.println(nI + " " + nJ + " " + tracker[nI][nJ]);
                        tracker[nI][nJ] = dist;
                        maxDist = Math.max(maxDist, dist);
                        q.add(new int[]{nI, nJ});
                    }
                }
            }
            System.out.println(Arrays.deepToString(tracker).replace("], ", "]\n").replace("[[", "[").replace("]]", "]") + "\n");
            qSize = q.size();
            dist++;
        }
        return maxDist;
    }
}
