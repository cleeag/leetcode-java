import java.util.Arrays;
import java.util.Comparator;

public class largestNumber179 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i + j;
                String s2 = j + i;
                return -s1.compareTo(s2);
            }
        });
        StringBuilder ans  = new StringBuilder();
        for (String s : strs) {
            if (ans.toString().equals("0") && s.equals("0")) continue;
            ans.append(s);
        }
        return ans.toString();
    }

    public boolean comp(int a, int b) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        return sa.compareTo(sb) > 0;
//        int i = 0;
//        for (; i < Math.min(sa.length(), sb.length()); i++) {
//            if (sa.charAt(i) == sb.charAt(i)) continue;
//            if (sa.charAt(i) < sb.charAt(i)) return
//        }

    }
}
