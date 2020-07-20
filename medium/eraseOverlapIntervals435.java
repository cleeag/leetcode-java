import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class eraseOverlapIntervals435 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        eraseOverlapIntervals435 tmp = new eraseOverlapIntervals435();
        tmp.eraseOverlapIntervals(a);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (s.size() == 0) s.push(i);
            else if (intervals[i][1] <= intervals[s.peek()][1]) {
                s.pop();
                ans++;
                s.push(i);
            } else if (intervals[i][0] >= intervals[s.peek()][1]) {
                s.push(i);
            } else ans++;
        }
        System.out.println(ans);
        return ans;
    }
}
