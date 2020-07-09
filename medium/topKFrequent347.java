import java.util.*;

public class topKFrequent347 {
    public static void main(String[] args) {
        topKFrequent347 tmp = new topKFrequent347();
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
//        int[] nums = new int[]{1};
//        int k = 1;
//        int[] nums = new int[]{4,1,-1,2,-1,2,3};
//        int k = 2;
        tmp.topKFrequent(nums, k);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, List<Integer>> count2num = new HashMap<>();
        for (int num : nums) numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        for (Integer num : numCount.keySet()) {
            if (count2num.get(numCount.get(num)) == null) {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(num);
                count2num.put(numCount.get(num), tmp);
            } else count2num.get(numCount.get(num)).add(num);
        }
        int[] countArr = new int[nums.length + 1];
        for (Integer count : count2num.keySet()) countArr[count] = 1;

        int i = countArr.length - 1;
        List<Integer> ansList = new LinkedList<>();
        while (i >= 0 && k > 0) {
            if (countArr[i] != 0) {
                ansList.addAll(count2num.get(i));
                k -= count2num.get(i).size();
            }
            i--;
        }
        int[] ans = new int[ansList.size()];
        for (int j = 0; j < ans.length; j++) ans[j] = ansList.get(j);

        System.out.println(numCount);
        System.out.println(count2num);
        System.out.println(Arrays.toString(countArr));
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
