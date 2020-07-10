public class gameOfLife289 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife289 tmp = new gameOfLife289();
        tmp.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] nextState = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nextState[i][j] = isAlive(board, i, j) ? 1 : 0;
            }
        }
        for (int i = 0; i < m; i++) {
            System.arraycopy(nextState[i], 0, board[i], 0, n);
        }
    }

    public boolean isAlive(int[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int aliveNeighbors = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (i + k >= 0 && i + k < m && j + l >= 0 && j + l < n && !(k==0&&l==0)
                        && board[i + k][j + l] == 1) aliveNeighbors++;
            }
        }
        System.out.println(i + " " + j + " " +  aliveNeighbors);
        if (board[i][j] == 1) {
            if (aliveNeighbors < 2) return false;
            else return aliveNeighbors == 2 || aliveNeighbors == 3;
        } else {
            return aliveNeighbors == 3;
        }
    }
}
