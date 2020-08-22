import java.util.LinkedList;
import java.util.List;

public class numsSameConsecDiff967 {
    public static void main(String[] args) {
//        int N = 3, K = 7;
        int N = 3, K = 0;
        numsSameConsecDiff967 tmp = new numsSameConsecDiff967();
        tmp.numsSameConsecDiff(N, K);
        System.out.println(tmp.res);
    }

    List<Integer> res = new LinkedList<>();

    public int[] numsSameConsecDiff(int N, int K) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, 0, N, K);
        }
        if (K == 1 && N == 0) res.add(0);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }

    public void dfs(int path, int idx, int N, int K) {
        System.out.println(path + " " + idx);
        if (idx == N - 1) {
            res.add(path);
            return;
        }
        int cur = path % 10;
        if (K == 0) {
            path = path * 10 + cur;
            dfs(path, idx + 1, N, K);
            return;
        }
        if (cur - K >= 0) {
            path = path * 10 + cur - K;
            dfs(path, idx + 1, N, K);
            path /= 10;
        }
        if (cur + K < 10) {
            path = path * 10 + cur + K;
            dfs(path, idx + 1, N, K);
            path /= 10;
        }
    }
}
