import java.util.*;

public class WordBreak140 {
    public static void main(String[] args) {
//        String s = "catsanddog";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
//
        String s = "pineapplepenappl";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));

        WordBreak140 tmp = new WordBreak140();
        tmp.wordBreak(s, wordDict);
    }


    List<String> ans = new LinkedList<>();
    Map<Integer, Set<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, 0, wordDict, new StringBuilder());
        System.out.println(ans);
        System.out.println(memo);
        return ans;
    }

    public Set<String> dfs(String s, int idx, List<String> wordDict, StringBuilder sb) {
        if (idx == s.length()) {
            ans.add(sb.toString());
            return null;
        }

        if (memo.containsKey(idx)) {
            Set<String> childAtIdx = memo.get(idx);
            String tmp = sb.append(" ").toString();
            for (String child : childAtIdx) {
                ans.add(tmp + child);
            }
            sb.deleteCharAt(sb.length()-1);
            return childAtIdx;
        }
        Set<String> childAtIdx = new HashSet<>();

        for (String word : wordDict) {
            if (s.substring(idx).startsWith(word)) {
                if (sb.length() > 0) sb.append(" ");
                int orgLen = sb.length();
                sb.append(word);
                Set<String> children = dfs(s, idx + word.length(), wordDict, sb);
                if (children == null) {
                    childAtIdx.add(word);
                } else {
                    for (String child : children) {
                        childAtIdx.add(word + " " + child);
                    }
                }
                for (int i = 0; i < word.length(); i++) sb.deleteCharAt(orgLen);
                if (orgLen > 0) sb.deleteCharAt(orgLen - 1);
            }
        }
        memo.put(idx, childAtIdx);
        return childAtIdx;
    }
}
