import java.util.*;

public class findAnagrams438 {
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
//        String s = "abab";
//        String p = "ab";
        String s = "acdcaeccde";
        String p = "c";

        findAnagrams438 tmp = new findAnagrams438();
        tmp.findAnagrams(s, p);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int pLeftLength = p.length();
        List<Integer> ans = new LinkedList<>();
        Map<Character, Integer> orgHMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            orgHMap.put(p.charAt(i), orgHMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        Map<Character, Integer> hMap = new HashMap<>(orgHMap);
        int i = 0, j = 0;
        while (j < s.length()) {
            System.out.println(i + " " + j);
            System.out.println(ans);
            System.out.println(hMap);
            System.out.println();
            if (!hMap.containsKey(s.charAt(j))) {
                pLeftLength = p.length();
                j++;
                i = j;
                hMap = new HashMap<>(orgHMap);
                continue;
            }

            while (hMap.get(s.charAt(j)) == 0) {
                hMap.put(s.charAt(i), hMap.get(s.charAt(i)) + 1);
                pLeftLength++;
                i++;
            }
            if (hMap.get(s.charAt(j)) > 0) {
                hMap.put(s.charAt(j), hMap.get(s.charAt(j)) - 1);
                pLeftLength--;
                j++;
                if (pLeftLength == 0) ans.add(i);
            }
        }
        System.out.println(ans);
        return ans;
    }
}
