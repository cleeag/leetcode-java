import java.util.PriorityQueue;

public class connectSticks1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int stick : sticks) p.offer(stick);
        int ans = 0;
        while (p.size() > 1){
            int s1 = p.poll();
            int s2 = p.poll();
            ans += s1 + s2;
            p.offer(s1 + s2);
        }
        return ans;
    }
}
