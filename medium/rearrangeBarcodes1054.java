import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class rearrangeBarcodes1054 {
    public static void main(String[] args) {
//        int[] b = new int[]{1, 1, 1, 1, 2, 2, 3, 3};
        int[] b = new int[]{1,1,1,2,2,2};
        rearrangeBarcodes1054 tmp = new rearrangeBarcodes1054();
        tmp.rearrangeBarcodes(b);
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] count = new int[10000];
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> -count[a]));
        for (int b : barcodes) count[b]++;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) q.offer(i);
        }
        int i = 0;
        int[] ans = new int[barcodes.length];
        int standBy = -1;
        while (q.size() > 0) {
            int cur = q.poll();
            ans[i++] = cur;
            count[cur]--;
            if (standBy != -1) q.offer(standBy);
            standBy = count[cur] > 0 ? cur : -1;
            System.out.println(Arrays.toString(ans));
        }
        return ans;
    }
}
