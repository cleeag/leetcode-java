import java.util.*;

public class doesCircleExist {
    public List<String> doesCircleExist(List<String> commands) {
        List<String> ans = new LinkedList<>();
        for (String command: commands) {
            int i = 0, j = 0, dir = 0;
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int k = 0; k < command.length(); k++) {
                if (command.charAt(k) == 'G'){
                    i += directions[dir][0];
                    j += directions[dir][1];
                }
                if (command.charAt(k) == 'R'){
                    dir = (dir + 1) % 4;
                } else if (command.charAt(k) == 'L'){
                    dir = (dir + 3) % 4;
                }
            }
            if ((i == 0 && j == 0) || dir != 0) ans.add("YES");
            else ans.add("NO");
        }
        return ans;
    }

}
