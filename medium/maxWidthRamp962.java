import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class maxWidthRamp962 {
    public static void main(String[] args) {
//        int[] a = new int[]{6, 0, 8, 2, 1, 5};
        int[] a = new int[]{9,8,1,0,1,9,4,0,4,1};
        maxWidthRamp962 tmp = new maxWidthRamp962();
        System.out.println(tmp.maxWidthRamp(a));
    }

    public int maxWidthRamp(int[] A) {
        List<Integer> downward = new ArrayList<>();
        int maxWidth = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] < A[downward.get(downward.size() - 1)]) downward.add(i);
            else {
                int lo = 0, hi = downward.size();
                int mid = 0;
                while (lo < hi) {
                    mid = (lo + hi) / 2;
                    if (A[downward.get(mid)] > A[i]) lo = mid + 1;
                    else hi = mid;
                }
                maxWidth = Math.max(maxWidth, i - downward.get(lo));
            }
        }
        return downward.size() == A.length ? 0 : maxWidth;
    }

    public int maxWidthRampTLE(int[] A) {
        List<Integer> downward = new LinkedList<>();
        int maxWidth = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (i == 0 || A[i] < A[downward.get(downward.size() - 1)]) downward.add(i);
            else {
                for (Integer idx : downward) {
                    if (A[i] >= A[idx]) maxWidth = Math.max(maxWidth, i - idx);
                }
            }
        }
        return downward.size() == A.length ? 0 : maxWidth;
    }
}
