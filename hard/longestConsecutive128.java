import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestConsecutive128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> intervals = new HashMap<>();
        Set<Integer> seen = new HashSet<>();
        int maxLen = 0;
        for (int num : nums) {
            System.out.println(num + " " + maxLen);
            System.out.println(intervals);
            if (intervals.containsKey(num) || seen.contains(num))continue;
            seen.add(num);
            if (!intervals.containsKey(num - 1) && !intervals.containsKey(num + 1)){
                intervals.put(num, num);
                maxLen = Math.max(1, maxLen);
            }
            if (intervals.containsKey(num + 1) && intervals.containsKey(num - 1)){
                int roof = intervals.get(num + 1);
                int floor = intervals.get(num - 1);
                intervals.remove(num + 1);
                intervals.remove(num - 1);
                intervals.remove(roof);
                intervals.remove(floor);
                intervals.put(floor, roof);
                intervals.put(roof, floor);
                maxLen = Math.max(Math.abs(roof - floor) + 1, maxLen);
            }
            else if (intervals.containsKey(num + 1)){
                int roof = intervals.get(num + 1);
                intervals.remove(roof);
                intervals.remove(num + 1);
                maxLen = Math.max(maxLen, Math.abs(roof - num) + 1);
                intervals.put(num, roof);
                intervals.put(roof, num);
            }
            else if (intervals.containsKey(num - 1)){
                int floor = intervals.get(num - 1);
                intervals.remove(num - 1);
                maxLen = Math.max(maxLen, Math.abs(num - floor) + 1);
                intervals.put(floor, num);
                intervals.put(num, floor);
            }
        }
        return maxLen;
    }
}
