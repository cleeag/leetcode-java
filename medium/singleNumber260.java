import java.util.HashSet;
import java.util.Set;

public class singleNumber260 {
    public static void main(String[] args) {
        int[] n = new int[]{1,2,1,3,2,5};
        singleNumber260 tmp = new singleNumber260();
        tmp.singleNumber(n);
    }
    public int[] singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) s.remove(num);
            else s.add(num);
        }
        int[] ans = new int[s.size()];
        int i = 0;
        for (Integer n : s) {
            ans[i++] = n;
        }
        System.out.println(s);
        return ans;
    }
}
