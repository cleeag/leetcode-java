import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class merge56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.size() == 0) {
                s.push(intervals[i]);
                continue;
            }
            if (intervals[i][0] <= s.peek()[1]){
                s.push(new int[]{s.peek()[0], Math.max(s.pop()[1], intervals[i][1])});
            } else {
                s.push(intervals[i]);
            }
        }
        int[][] ans = new int[s.size()][2];
        while (s.size() > 0) ans[s.size()-1] = s.pop();
        return ans;
    }
}
