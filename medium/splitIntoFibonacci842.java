import java.util.LinkedList;
import java.util.List;

public class splitIntoFibonacci842 {
    public static void main(String[] args) {
//        String S = "123456579";
//        String S = "11235813";
//        String S = "112358130";
//        String  S = "112";
//        String S = "1011";
        String S = "214748364721474836422147483641";
        splitIntoFibonacci842 tmp = new splitIntoFibonacci842();
        System.out.println(tmp.splitIntoFibonacci(S));
    }

    List<Integer> ans = new LinkedList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        for (int i = 1; i < S.length() / 2 + 1; i++) {
            if (i > 1 && S.charAt(0) == '0') break;
            List<Integer> path = new LinkedList<>();
            long num = Long.parseLong(S.substring(0, i));
            if (num > Integer.MAX_VALUE) break;
            int start = (int) num;
            path.add(start);
            if (dfs(S, start, i, path)) return ans;
            path.remove(path.size() - 1);
        }
        System.out.println(ans);
        return ans;
    }

    public boolean dfs(String S, int a, int idx, List<Integer> path) {
        System.out.println(idx + " " + a);
        System.out.println(path);
        if (idx == S.length()) {
            ans = path;
            return true;
        }
        for (int i = idx + 1; i < S.length(); i++) {
            if (i - idx > S.length() - i + 1) break;
            if (i - idx > 1 && S.charAt(idx) == '0') break;
            long num = Long.parseLong(S.substring(idx, i));
            if (num > Integer.MAX_VALUE) break;
            int b = (int) num;
            int tmp = a + b;
            if (S.startsWith(String.valueOf(tmp), i)) {
                path.add(b);
                if (i + String.valueOf(tmp).length() == S.length()) {
                    path.add(tmp);
                    ans = path;
                    return true;
                } else if (dfs(S, b, i, path)) return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }
}
