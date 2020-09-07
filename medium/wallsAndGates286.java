import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates286 {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) q.add(new int[]{i, j});
            }
        }
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int distancs = 0;
        int qSize = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < qSize; i++) {
                int[] curPoint = q.poll();
                int cI = curPoint[0], cJ = curPoint[1];
                rooms[cI][cJ] = Math.min(rooms[cI][cJ], distancs);
                for (int[] dir : directions) {
                    int newI = cI + dir[0], newJ = cJ + dir[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && rooms[newI][newJ] == Integer.MAX_VALUE) {
                        q.add(new int[]{newI, newJ});
                    }
                }
            }
            qSize = q.size();
            distancs++;
        }
    }
}
