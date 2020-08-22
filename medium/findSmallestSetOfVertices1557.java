import java.util.LinkedList;
import java.util.List;

public class findSmallestSetOfVertices1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] count = new int[n];
        for (List<Integer> edge : edges) {
            count[edge.get(1)]++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) ans.add(i);
        }
        System.out.println(ans);
        return ans;
    }
}
