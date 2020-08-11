import java.util.HashMap;
import java.util.Map;

public class numMatchingSubseq792 {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        Map<String, Integer> hMap = new HashMap<>();

        for (String word : words) {
            if (hMap.get(word) != null && hMap.get(word) == 1){
                ans++;
                continue;
            } else if (hMap.get(word) != null && hMap.get(word) == 0){
                continue;
            }
            int i = 0, j = 0;
            while (i < S.length() && j < word.length()){
                if (S.charAt(i) == word.charAt(j)){
                    i++;
                    j++;
                } else i++;
            }
            if (j == word.length()) {
                ans++;
                hMap.put(word, 1);
            } else {
                hMap.put(word, 0);
            }
        }
        return ans;
    }
}
