import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class minMeetingRooms253 {
    public static void main(String[] args) {
        int[][] i = new int[][]{{2,15},{36,45},{9,29},{16,23},{4,9}};
        minMeetingRooms253 tmp = new minMeetingRooms253();
        tmp.minMeetingRooms(i);
    }
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.offer(intervals[0][1]);
        int ans = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < p.peek()) {
                ans++;
            }else{
                p.poll();
            }
            p.offer(intervals[i][1]);
        }
        System.out.println(ans);
        return ans;
    }
}
