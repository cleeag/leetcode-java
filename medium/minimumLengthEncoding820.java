import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class minimumLengthEncoding820 {
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode cur = trie;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                cur = cur.get(c);
            }
        }
        int ans = 0;
        int wordCount = 0;
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            if (seen.contains(word)) continue;
            TrieNode cur = trie;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                cur = cur.get(c);
            }
            if (cur.count == 0){
                ans += word.length();
                wordCount += 1;
            }
            seen.add(word);
        }
        return ans + wordCount;
    }
}
