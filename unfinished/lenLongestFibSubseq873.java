import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lenLongestFibSubseq873 {
    public int lenLongestFibSubseq(int[] A) {
        if (A.length < 3) return 0;
        Map<Integer, Integer> longest = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                longest.put(i + j,
                        1 + longest.getOrDefault(i, 1) + longest.getOrDefault(j, 1));
            }
        }
        return 0;
    }
}
