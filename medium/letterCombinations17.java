import java.util.LinkedList;
import java.util.List;

public class letterCombinations17 {
    List<String> ans = new LinkedList<>();
    String[] keys = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        dfs(digits, 0, new StringBuilder());
        return ans;
    }

    public void dfs(String digits, int idx, StringBuilder sb){
        if (idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        System.out.println(digits.charAt(idx));
        String key = keys[Character.getNumericValue(digits.charAt(idx))];
        for (int i = 0; i < key.length(); i++) {
            sb.append(key.charAt(i));
            dfs(digits, idx+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
