import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findSubstringInWraproundString467 {
    public static void main(String[] args) {
//        String p = "zabbc";
//        String p = "a";
        String p = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        findSubstringInWraproundString467 tmp = new findSubstringInWraproundString467();
        System.out.println(tmp.findSubstringInWraproundString(p));
    }

    public int findSubstringInWraproundString(String p) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            alpha.put(s.charAt(i), i);
        }
        int[] used = new int[s.length()];
        s += s;

        int ans = 0;
        int i = 0;
        while (i < p.length()) {
            int l = 1;
            while (i + l < p.length()
                    && p.charAt(i + l) == s.charAt(alpha.get(p.charAt(i + l - 1)) + 1)) {
                l++;
            }
            int j = i + l;
            System.out.println(i + " " + j);
            for (int k = 1; k < j - i + 1; k++) {
                ans += k;
            }
            int usedCount = 0;
            for (int k = i; k < j; k++) {
                if (used[alpha.get(p.charAt(k))] == 1) {
                    usedCount++;
                    ans -= usedCount;
                } else usedCount = 0;
            }
            for (int k = i; k < j; k++) {
                used[alpha.get(p.charAt(k))] = 1;
            }
            i = j;
            System.out.println(ans);
            System.out.println(Arrays.toString(used));
        }
        return ans;
    }
}
