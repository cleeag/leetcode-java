import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordBreak140 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));

//        String s = "pineapplepenapple";
//        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));

        WordBreak140 tmp = new WordBreak140();
        tmp.wordBreak(s, wordDict);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new LinkedList<>();

        List<List<Integer>> table = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); i++) table.add(new LinkedList<>());

        for (int i = s.length(); i > 0 ; i--) {
            for (String curWord : wordDict) {
                if (i - curWord.length() < 0) continue;
                else if (s.substring(i - curWord.length(), i).equals(curWord))
                    table.get(i - 1).add(i - curWord.length() - 1);
            }
        }
        System.out.println(Arrays.deepToString(table.toArray()));
        List<String> path = new LinkedList<>();
        rec(s, ans, path, s.length()-1, table);
        System.out.println(ans);
        return ans;
    }

    public void rec(String s, List<String> ans, List<String> path, int idx, List<List<Integer>> table){
//        System.out.println(idx);
//        System.out.println(path);
        if (idx == -1)
            ans.add(String.join(" ", path));
        else if (table.get(idx).size() == 0)
            return;
        else{
            for (int prevPosition: table.get(idx)) {
                List<String> path2 = new LinkedList<>(path);
                path2.add(0, s.substring(prevPosition + 1, idx + 1));
                rec(s, ans, path2, prevPosition, table);
            }
        }


    }
}
