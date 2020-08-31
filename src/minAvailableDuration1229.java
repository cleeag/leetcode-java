import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class minAvailableDuration1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        if (slots1.length == 0 || slots2.length == 0) return new LinkedList<>();
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));
        List<Integer> ans = new LinkedList<>();
        int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
            int[] time1 = slots1[i];
            int[] time2 = slots2[j];
            System.out.println(Arrays.toString(time1));
            System.out.println(Arrays.toString(time2));
            if ((time1[1] >= time2[1] && time1[0] < time2[1]) || (time2[1] >= time1[1] && time2[0] < time1[1])) {
                if (Math.min(time1[1], time2[1]) - Math.max(time1[0], time2[0]) >= duration) {
                    ans.add(Math.max(time1[0], time2[0]));
                    ans.add(ans.get(0) + duration);
                    return ans;
                }
            }
            if (time1[1] > time2[1]) j++;
            else if (time2[1] > time1[1]) i++;
            else {
                i++;
                j++;
            }
        }
        return new LinkedList<>();
    }
}
