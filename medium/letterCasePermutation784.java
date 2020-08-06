import java.util.LinkedList;
import java.util.List;

public class letterCasePermutation784 {
    public static void main(String[] args) {
        String s = "a1b2";
        letterCasePermutation784 tmp = new letterCasePermutation784();
        tmp.letterCasePermutation(s);
    }
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new LinkedList<>();
        if (S.length() > 0) dfs(ans, S, S, 0);
        System.out.println(ans);
        return ans;
    }

    public void dfs(List<String> ans, String S, String path, int idx) {
        if (idx == S.length()) {
            ans.add(path);
            return;
        }
        dfs(ans, S, path, idx + 1);
        if (!Character.isDigit(S.charAt(idx))) {
            StringBuilder newPath = new StringBuilder();
            newPath.append(path, 0, idx);
            if (Character.isUpperCase(S.charAt(idx))) newPath.append(Character.toLowerCase(S.charAt(idx)));
            else newPath.append(Character.toUpperCase(S.charAt(idx)));
            if (idx < S.length() - 1) newPath.append(path, idx + 1, S.length());

            dfs(ans, S, newPath.toString(), idx + 1);
        }
    }
}
