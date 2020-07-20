import java.util.HashMap;
import java.util.Map;

public class checkInclusion567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        checkInclusion567 tmp = new checkInclusion567();
        System.out.println(tmp.checkInclusion(s1, s2));
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> orgHMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) orgHMap.put(s1.charAt(i), orgHMap.getOrDefault(s1.charAt(i), 0) + 1);

        Map<Character, Integer> hMap = new HashMap<>(orgHMap);
        int i = 0, j = 0, matchLen = 0;
        while (j < s2.length()) {
            if (!hMap.containsKey(s2.charAt(j))) {
                j++;
                i = j;
                hMap = new HashMap<>(orgHMap);
                matchLen = 0;
                continue;
            }
            while (hMap.get(s2.charAt(j)) == 0) {
                hMap.put(s2.charAt(i), hMap.get(s2.charAt(i)) + 1);
                i++;
                matchLen--;
            }
            if (hMap.get(s2.charAt(j)) > 0) {
                hMap.put(s2.charAt(j), hMap.get(s2.charAt(j)) - 1);
                j++;
                matchLen++;
                if (matchLen == s1.length()) return true;
            }
        }
        return false;
    }
}
