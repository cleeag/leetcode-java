import java.util.*;

public class findAllConcatenatedWordsInADict472 {
    List<String> ans = new LinkedList<>();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words.length == 0) return ans;
        Arrays.sort(words);
        StringBuilder sb = new StringBuilder();
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        for (int i = words.length - 1; i >= 0; i--) {
            dfs(wordSet, words[i], 0, sb, 0);
        }
        return ans;
    }

    public boolean dfs(Set<String> words, String target, int idx, StringBuilder sb, int wordCount) {
        if (idx == target.length()){
            if (wordCount == 1) return false;
            ans.add(target);
            return true;
        }
        int orgLen = sb.length();
        for (String word : words) {
            if (target.substring(idx).startsWith(word)) {
                sb.append(word);
                boolean tmp = dfs(words, target, idx + word.length(), sb, wordCount + 1);
                for (int i = 0; i < word.length(); i++) sb.deleteCharAt(orgLen);
                if (tmp) return true;
            }
        }
        return false;
    }
}
