import com.sun.source.tree.ReturnTree;

import java.util.*;
import java.util.concurrent.RecursiveTask;

public class avoidFlood1488 {
    public static void main(String[] args) {
//        int[] d = new int[] {1,2,0,0,2,1};
//        int[] d = new int[] {1,2,3,4};
//        int[] d = new int[] {69,0,0,0,69};
//        int[] d = new int[]{1,0,2,3,0,1,2};
        int[] d = new int[]{2,3,0,0,3,1,0,1,0,2,2};
        avoidFlood1488 tmp = new avoidFlood1488();
        int[] ans = tmp.avoidFlood(d);
        System.out.println(Arrays.toString(ans));
    }
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        List<Integer> dryDays = new LinkedList<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                ans[i] = -1;
                if (fullLakes.containsKey(rains[i]) && dryDays.size() > 0){
                    boolean fail = true;
                    int day = 0;
                    for (Integer dryDay : dryDays) {
                        if (dryDay > fullLakes.get(rains[i])){
                            fail = false;
                            day = dryDay;
                            break;
                        }
                    }
                    if (fail) return new int[0];

                    ans[day] = rains[i];
                    fullLakes.remove(rains[i]);
                    fullLakes.put(rains[i], i);
                    dryDays.remove(Integer.valueOf(day));
                }
                else if (fullLakes.containsKey(rains[i]))
                    return new int[0];
                else if (!fullLakes.containsKey(rains[i])){
                    fullLakes.put(rains[i], i);
                }
            }
            else {
                dryDays.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
