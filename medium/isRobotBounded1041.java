public class isRobotBounded1041 {
    public boolean isRobotBounded(String instructions) {
        int i = 0, j = 0, dir = 0;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int k = 0; k < instructions.length(); k++) {
            if (instructions.charAt(k) == 'G'){
                i += directions[dir][0];
                j += directions[dir][1];
            }
            if (instructions.charAt(k) == 'R'){
                dir = (dir + 1) % 4;
            } else if (instructions.charAt(k) == 'L'){
                dir = (dir + 3) % 4;
            }
        }
        return ((i == 0 && j == 0) || dir != 0);
    }
}
