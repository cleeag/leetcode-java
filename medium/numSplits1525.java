import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class numSplits1525 {
    public static void main(String[] args) {
        String s = "aacaba";
        numSplits1525 tmp = new numSplits1525();
        tmp.numSplits(s);
    }
    public int numSplits(String s) {
        if (s.length() == 1) return 0;
        if (s.length() == 2) return 1;

        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        leftMap.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) rightMap.put(s.charAt(i), rightMap.getOrDefault(s.charAt(i), 0) + 1);

        int i = 1;
        int ans = 0;
        while (i < s.length()) {
            if (leftMap.size() == rightMap.size()) ans++;
            leftMap.put(s.charAt(i), leftMap.getOrDefault(s.charAt(i), 0) + 1);
            if (rightMap.get(s.charAt(i)) == 1) rightMap.remove(s.charAt(i));
            else rightMap.put(s.charAt(i), rightMap.get(s.charAt(i)) - 1);
            i++;
        }
        System.out.println(ans);
        return ans;
    }
}
