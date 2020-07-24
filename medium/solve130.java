import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class solve130 {
    public static void main(String[] args) {
        solve130 tmp = new solve130();
        char[][] a = {{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O' }, {'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O' }, {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X' }, {'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O' }, {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X' }, {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' }};
        tmp.solve(a);
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int m = board.length, n = board[0].length;
        char[][] tracker = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && tracker[i][j] == 0) bfs(board, tracker, i, j);
            }
        }
    }

    public void bfs(char[][] board, char[][] tracker, int initI, int initJ) {
        System.out.println("bfs");
        int m = board.length, n = board[0].length;
        List<int[]> cords = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{initI, initJ});
        boolean alive = false;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
//            System.out.println(Arrays.toString(tmp));
            int i = tmp[0], j = tmp[1];
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) alive = true;
            cords.add(tmp);
            if (i + 1 < m && board[i + 1][j] == 'O' && tracker[i + 1][j] == 0) {
                q.add(new int[]{i + 1, j});
                tracker[i+1][j] = 1;
            }
            if (i - 1 >= 0 && board[i - 1][j] == 'O' && tracker[i - 1][j] == 0) {
                q.add(new int[]{i - 1, j});
                tracker[i-1][j] = 1;
            }
            if (j + 1 < n && board[i][j + 1] == 'O' && tracker[i][j + 1] == 0) {
                q.add(new int[]{i, j + 1});
                tracker[i][j+1] = 1;
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O' && tracker[i][j - 1] == 0) {
                q.add(new int[]{i, j - 1});
                tracker[i][j-1] = 1;
            }
        }
        if (!alive) {
            for (int[] c : cords) {
                board[c[0]][c[1]] = 'X';
            }
        }
    }
}
