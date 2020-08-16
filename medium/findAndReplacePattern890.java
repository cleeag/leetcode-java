import java.util.*;

public class findAndReplacePattern890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Character> hMap = new HashMap<>();
        Set<Character> s = new HashSet<>();
        List<String> ans = new LinkedList<>();
        for (String word : words) {
            hMap.clear();
            s.clear();
            boolean no = false;
            for (int i = 0; i < word.length(); i++) {
                if (hMap.containsKey(pattern.charAt(i)) && hMap.get(pattern.charAt(i)) != word.charAt(i)
                        || !hMap.containsKey(pattern.charAt(i)) && s.contains(word.charAt(i))) {
                    no = true;
                    break;
                }
                hMap.put(pattern.charAt(i), word.charAt(i));
                s.add(word.charAt(i));
            }
            if (!no) ans.add(word);
        }
        return ans;
    }
}
