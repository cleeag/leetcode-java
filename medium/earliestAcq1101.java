import java.util.Arrays;
import java.util.Comparator;

public class earliestAcq1101 {
    public static void main(String[] args) {
//        int[][] l = new int[][]{{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
//        int n = 6;

        int[][] l = new int[][]{{3, 0, 3}, {4, 1, 2}, {0, 2, 0}, {2, 0, 2}, {8, 0, 3}, {1, 0, 1}, {5, 1, 2}, {7, 3, 1}, {6, 1, 0}, {9, 3, 0}};
        int n = 4;
        earliestAcq1101 tmp = new earliestAcq1101();
        System.out.println(tmp.earliestAcq(l, n));
    }

    int[] u;

    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        u = new int[N];
        Arrays.fill(u, -1);
        int n = N;
        for (int[] log : logs) {
            if (find(log[1]) != find(log[2])) n--;
            if (n == 1) return log[0];
            union(log[1], log[2]);
        }
        return -1;
    }

    public void union(int x, int y) {
        u[find(x)] = find(y);
    }

    public int find(int x) {
        if (u[x] == -1) u[x] = x;
        if (x != u[x]) u[x] = find(u[x]);
        return u[x];
    }
}
