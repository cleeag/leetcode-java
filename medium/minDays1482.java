import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class minDays1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int n = bloomDay.length, left = 1, right = (int)1e9;

        while (left < right) {
            int day = (left + right) / 2;
            int flow = 0;
            int bouqCount = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] > day) flow=0;
                else if (++flow >= k) {
                    bouqCount++;
                    flow = 0;
                }
            }
            if (bouqCount < m) left = day + 1;
            else right = day;
        }
        return left;
    }
}
