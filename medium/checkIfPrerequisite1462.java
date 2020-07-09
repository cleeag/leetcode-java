import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class checkIfPrerequisite1462 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] connected = new boolean[n][n];
        for (int[] prerequisite : prerequisites) connected[prerequisite[0]][prerequisite[1]] = true;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    connected[i][j] = connected[i][j] || (connected[i][k] && connected[k][j]);
                }
            }
        }
        List<Boolean> ans = new LinkedList<>();
        for (int[] q : queries) {
            ans.add(connected[q[0]][q[1]]);
        }
        return ans;
    }
}
