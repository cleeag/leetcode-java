import java.util.HashMap;
import java.util.Map;

public class customSortString791 {
    public String customSortString(String S, String T) {
        Map<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < T.length(); i++)
            hMap.put(T.charAt(i), hMap.getOrDefault(T.charAt(i), 0) + 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (!hMap.containsKey(S.charAt(i))) continue;
            sb.append(String.valueOf(S.charAt(i)).repeat(hMap.get(S.charAt(i))));
            hMap.remove(S.charAt(i));
        }
        for (Character leftover : hMap.keySet()) {
            sb.append(String.valueOf(leftover).repeat(hMap.get(leftover)));
        }
        return sb.toString();
    }
}
