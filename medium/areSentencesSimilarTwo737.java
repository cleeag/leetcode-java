import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class areSentencesSimilarTwo737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : pairs) {
            String word1 = pair.get(0);
            String word2 = pair.get(1);
            if (!map.containsKey(word1)) map.put(word1, word1);
            if (!map.containsKey(word2)) map.put(word2, word2);
            setParent(pair.get(0), pair.get(1), map);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!getParent(words1[i], map).equals(getParent(words2[i], map))) return false;
            System.out.println(map);
        }
        return true;
    }

    public String getParent(String word, Map<String, String> map) {
        if (!map.containsKey(word)) return word;
        while (!map.get(word).equals(word))
            word = map.get(word);
        return word;
    }

    public void setParent(String word1, String word2, Map<String, String> map) {
        map.put(getParent(word1, map), getParent(word2, map));
    }
}
