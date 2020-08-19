import java.util.*;

public class minIncrementForUnique945 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 2, 1, 2, 1, 7};
//        int[] a = new int[]{2, 2, 1};
//        int[] a = new int[]{7, 2, 7, 2, 1, 4, 3, 1, 4, 8};
        minIncrementForUnique945 tmp = new minIncrementForUnique945();
        System.out.println(tmp.minIncrementForUnique(a));
    }

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) return 0;
        Arrays.sort(A);
        Queue<Integer> dups = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1]) dups.add(A[i]);
            else if (A[i] - A[i - 1] > 1) {
                for (int j = 0; j < A[i] - A[i - 1] - 1 && dups.size() > 0; j++) {
//                    System.out.println(A[i] + " " + dups + " " + ans);
                    ans += A[i - 1] + 1 + j - dups.poll();
                }
            }
        }
//        System.out.println(dups);
        int max = A[A.length - 1];
        int i = 1;
        while (dups.size() > 0) {
            ans += max + i - dups.poll();
            i++;
        }
//        System.out.println(Arrays.toString(A));
        return ans;
    }
}
