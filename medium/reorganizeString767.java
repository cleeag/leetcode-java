import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class reorganizeString767 {
    public static void main(String[] args) {
//        String s = "aaaabbc";
//        String s = "aaa";
//        String s = "aba";r
//        String s = "vvvlo";
//        String s = "baaba";
        String s = "aaba";
        reorganizeString767 tmp = new reorganizeString767();
        System.out.println(tmp.reorganizeString(s));
    }

    public String reorganizeString(String S) {
        if (S.length() == 0) return "";
        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); i++) counts[S.charAt(i) - 'a']++;
        for (int i = 0; i < counts.length; i++) if (counts[i] > 0) p.offer(new int[]{i, counts[i]});

        char[] ans = new char[S.length()];
        int i = 0;
        int[] standby = null;
        while (!p.isEmpty()) {
            int[] tmp = p.poll();
            ans[i] = (char) (tmp[0] + 97);
            tmp[1]--;
            i++;

            if (standby != null) p.offer(standby);
            if (tmp[1] > 0) {
                standby = tmp;
            } else standby = null;
            System.out.println(Arrays.toString(ans));
        }
        if (standby != null) {
            if (standby[1] > 1 || (char) (standby[0] + 97) == ans[i-1]) return "";
            ans[ans.length - 1] = (char) (standby[0] + 97);
        }
        System.out.println(Arrays.toString(ans));
        return String.valueOf(ans);
    }
}
