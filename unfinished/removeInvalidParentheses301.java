import java.util.LinkedList;
import java.util.List;

public class removeInvalidParentheses301 {
    List<String> ans = new LinkedList<>();

    public List<String> removeInvalidParentheses(String s) {
        return new LinkedList<>();
    }

    public void dfs(String s, int idx, StringBuilder sb, int left) {
        if (idx == s.length()) {
            if (left == 0) ans.add(sb.toString());
            return;
        }
        if (s.charAt(idx) == '(') {
            sb.append('(');
            dfs(s, idx + 1, sb, left + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else if (s.charAt(idx) == ')') {
            if (left > 0){

            }
        } else {

        }

    }

}
