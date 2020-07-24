import java.util.LinkedList;
import java.util.List;

public class partition131 {
    public static void main(String[] args) {
//        String s = "aab";
//        String s = "abbab";
        String s = "danaranad";
        partition131 tmp = new partition131();
        tmp.partition(s);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        dfs(s, ans, new LinkedList<>(), 0);
        System.out.println(ans);
        return ans;
    }

    public void dfs(String s, List<List<String>> ans, List<String> path, int idx) {
        System.out.println(path);
        if (idx >= s.length()) {
            ans.add(path);
            System.out.println(ans);
            System.out.println();
            return;
        }
        List<String> tmpList = new LinkedList<>(path);
        tmpList.add(String.valueOf(s.charAt(idx)));
        dfs(s, ans, tmpList, idx + 1);

        if (path.size() > 0 && String.valueOf(s.charAt(idx)).equals(path.get(path.size() - 1))) {
            System.out.println(2);
            List<String> newPath = new LinkedList<>(path);
            String tmp = newPath.get(newPath.size() - 1) + s.charAt(idx);
            newPath.remove(newPath.size() - 1);
            newPath.add(tmp);
            dfs(s, ans, newPath, idx + 1);
        }

        if (path.size() >= 2 && String.valueOf(s.charAt(idx)).equals(path.get(path.size() - 2))) {
            System.out.println(3);
            List<String> newPath = new LinkedList<>(path);
            String tmp = newPath.get(newPath.size() - 2) + newPath.get(newPath.size() - 1) + s.charAt(idx);
            newPath.remove(newPath.size() - 1);
            newPath.remove(newPath.size() - 1);
            newPath.add(tmp);
            dfs(s, ans, newPath, idx + 1);
        }
    }
}
