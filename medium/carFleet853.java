import java.util.Comparator;
import java.util.PriorityQueue;

public class carFleet853 {
    public static void main(String[] args) {
//        int t = 12;
//        int[] p = {10,8,0,5,3};
//        int[] s = {2,4,1,1,3};
        int t = 10;
        int[] p = {6,8};
        int[] s = {3, 2};
        carFleet853 tmp = new carFleet853();
        tmp.carFleet(t, p, s);
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) return 0;
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.comparingInt(o->-position[o]));
        for (int i = 0; i < position.length; i++) p.offer(i);

        int fleet = 0;
        int cur = p.poll();
        while (p.size() > 0){
            int next = p.poll();
            if ((double)(target - position[cur]) / (double) speed[cur]
                    < (double)(target - position[next]) / (double)speed[next]){
                fleet++;
                cur = next;
            }
            System.out.println(fleet + " " + cur + " " + next);
        }
        return fleet + 1;
    }
}
