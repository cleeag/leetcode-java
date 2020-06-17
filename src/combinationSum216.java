import java.util.LinkedList;
import java.util.List;

public class combinationSum216 {
    public static void main(String[] args) {
        int k = 3, n = 9;
        combinationSum216 tmp = new combinationSum216();
        tmp.combinationSum3(k, n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        if (k == 0 || n == 0) return ans;
        dfs(ans, new LinkedList<>(), 1, k, n);
        System.out.println(ans);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> path, int curIdx, int k, int n) {
        System.out.println(curIdx + " " + k + " " + n);
        System.out.println(path);
        if (n == 0 && k == 0) ans.add(path);
        if (n > 0 && k > 0 && curIdx <= n) {
            for (int i = curIdx; i <= 9; i++) {
                if (i > n) break;
                List<Integer> newPath = new LinkedList<>(path);
                newPath.add(i);
                dfs(ans, newPath, i + 1, k - 1, n - i);
            }
        }
    }
}
