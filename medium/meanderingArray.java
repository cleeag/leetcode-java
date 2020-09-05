import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class meanderingArray {
    public List<Integer> meanderingArray(List<Integer> unsorted) {
        unsorted.sort(Integer::compareTo);
        int i = 0, j = unsorted.size() - 1;
        int turn = 1;
        List<Integer> ans = new LinkedList<>();
        while (i < j) {
            if (turn == -1) {
                ans.add(unsorted.get(i++));
                turn = 1;
            } else {
                ans.add(unsorted.get(j--));
                turn = -1;
            }
        }
        return ans;
    }
}
