import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class maximumMinimumPath1102 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{2,2,1,2,2,2},{1,2,2,2,1,2}};
        maximumMinimumPath1102 tmp = new maximumMinimumPath1102();
        tmp.maximumMinimumPath(a);
    }
    public int maximumMinimumPath(int[][] A) {
        if (A.length == 0) return 0;
        int m = A.length, n = A[0].length;
        int[][] tracker = new int[m][n];
        tracker[0][0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -A[o[0]][o[1]]));
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        pq.add(new int[]{0, 0});
        int minVal = A[0][0];
        while (pq.size() > 0) {
            int[] curPoint = pq.poll();
            System.out.println(pq);
            System.out.println(Arrays.toString(curPoint));
            int cI = curPoint[0], cJ = curPoint[1];
            minVal = Math.min(minVal, A[cI][cJ]);
            for (int[] dir : directions) {
                int nI = cI + dir[0], nJ = cJ + dir[1];
                if (nI >= 0 && nI < m && nJ >= 0 && nJ < n && tracker[nI][nJ] == 0) {
                    if (nI == m - 1 && nJ == n - 1) return Math.min(minVal, A[nI][nJ]);
                    tracker[nI][nJ] = 1;
                    pq.add(new int[]{nI, nJ});
                }
            }
        }
        return minVal;
    }
}
