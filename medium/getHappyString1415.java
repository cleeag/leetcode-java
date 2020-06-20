import java.util.LinkedList;
import java.util.List;

public class getHappyString1415 {
    public static void main(String[] args) {
        getHappyString1415 tmp = new getHappyString1415();
        tmp.getHappyString(10, 100);
    }

    public String getHappyString(int n, int k) {
        List<String> ans = new LinkedList<>();
        char[] candidate = new char[]{'a', 'b', 'c'};
        String tmp = rec(candidate, ans, "", n, k);
        System.out.println(ans);
        System.out.println(tmp);
        return tmp;
    }

    public String rec(char[] candidate, List<String> ans, String path, int n, int k) {
        if (path.length() == n) {
            ans.add(path);
            if (ans.size() == k) return ans.get(ans.size() - 1);
            else return "";
        }
        for (char c : candidate) {
            if (path.length() == 0 || c != path.charAt(path.length() - 1)) {
                String tmp = rec(candidate, ans, path + c, n, k);
                if (tmp.length() == n) return tmp;
            }
        }
        return "";
    }
}
