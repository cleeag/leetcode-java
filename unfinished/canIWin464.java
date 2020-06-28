import java.util.HashMap;
import java.util.Map;

public class canIWin464 {
    public static void main(String[] args) {
        canIWin464 tmp = new canIWin464();
        boolean tmpp = tmp.canIWin(4, 6);

        System.out.println(tmpp);
    }
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Map<Integer, Integer> tracker = new HashMap<>();
        for (int i = 0; i < maxChoosableInteger; i++) {
            tracker.put(i + 1, 0);
        }
        return dfs(tracker, 0, desiredTotal);
    }

    public boolean didIwin(Map<Integer, Integer> tracker, int turn, int target) {
//        if (turn == 1 && tracker.getOrDefault(target, -1) == 0) return false;

        boolean win;
        for (Integer i : tracker.keySet()) {
            if (tracker.get(i) == 1) continue;
            else if (i >= target) {
                return turn == 0;
            }
            else {
                tracker.put(i, 1);
                System.out.println(turn);
                System.out.println(i);
                System.out.println(tracker);
                System.out.println(target - i);
                System.out.println();
                win = didIwin(tracker, turn == 1 ? 0 : 1, target - i);
                if (!win) return false;
                tracker.put(i, 0);
            }
        }
        return true;
    }
}
