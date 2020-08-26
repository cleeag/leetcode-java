import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class longestStrChain1048 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> hMap = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, hMap.getOrDefault(prev, 0) + 1);
            }
            hMap.put(word, best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}
