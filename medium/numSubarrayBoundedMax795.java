import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class numSubarrayBoundedMax795 {
    public static void main(String[] args) {
        int[] A= new int[]{2,1,4,3};
        int l = 2;
        int r = 3;
//        int[] A= new int[]{7,3,6,7,1};
//        int l = 1;
//        int r = 4;
//        int[] A = new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
//        int l = 32;
//        int r = 69;
//        int[] A = new int[]{45, 2, 49, 6, 55, 73, 27, 17, 4, 71};
//        int l = 17;
//        int r = 33;
        numSubarrayBoundedMax795 tmp = new numSubarrayBoundedMax795();
        System.out.println(tmp.numSubarrayBoundedMax(A, l, r));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if (A.length == 0) return 0;
        int ans = 0;
        int i = 0, j = 0;
        Map<Integer, Integer> hMap = new HashMap<>();
        Queue<Integer> nextBigThing = new LinkedList<>();
        while (i < A.length || j < A.length) {
            while (i < A.length && j < A.length && i == j && A[i] > R) {
                i++;
                j++;
            }
            while (j < A.length && A[j] <= R) {
                if (A[j] >= L && A[j] <= R) {
                    hMap.put(A[j], hMap.getOrDefault(A[j], 0) + 1);
                    nextBigThing.add(j);
                }
                j++;
            }
            if (hMap.size() > 0) {
                if (!hMap.containsKey(A[i])) {
                    ans += j - nextBigThing.peek();
                } else {
                    ans += j - i;
                    nextBigThing.poll();
                }
            }
            System.out.println(i + " " + j + " " + ans);
            System.out.println(hMap);
            if (i < A.length && hMap.containsKey(A[i])) {
                if (hMap.get(A[i]) == 1) hMap.remove(A[i]);
                else hMap.put(A[i], hMap.get(A[i]) - 1);
            }
            i++;
        }
        return ans;
    }
}
