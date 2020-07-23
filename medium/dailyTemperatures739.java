import java.util.Stack;

public class dailyTemperatures739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            int days = 1;
            while (s.size() > 0 && T[i] > T[s.peek()]) {
                int prevDay = s.pop();
                ans[prevDay] = i - prevDay;
            }
            s.push(i);
        }
        while (s.size() > 0) ans[s.pop()] = 0;
        return ans;
    }
}
