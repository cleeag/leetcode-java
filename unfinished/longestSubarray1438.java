import java.util.Deque;
import java.util.LinkedList;

public class longestSubarray1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> inc = new LinkedList<>();
        Deque<Integer> dec = new LinkedList<>();
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {

            if (dec.size() > 0 && Math.abs(nums[i] - nums[dec.peekLast()]) > limit) {
                while (inc.size() > 0 && inc.peekFirst() <= dec.peekLast()) inc.pollFirst();
                dec.clear();
            }

            if (inc.size() > 0 && Math.abs(nums[i] - nums[inc.peekLast()]) > limit) {
                while (dec.size() > 0 && dec.peekFirst() <= inc.peekLast()) dec.pollFirst();
                inc.clear();
            }

            if (dec.size() > 0)maxLen = Math.max(maxLen, i - dec.pollFirst());

            if (inc.size() == 0 || nums[i] > nums[inc.peekLast()]) inc.add(i);
            if (dec.size() == 0 || nums[i] < nums[dec.peekLast()]) dec.add(i);
        }


        return 0;
    }
}
