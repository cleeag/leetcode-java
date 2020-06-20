import javax.lang.model.SourceVersion;
import java.util.Arrays;
import java.util.Stack;

public class sumSubarrayMins907 {
    public static void main(String[] args) {
        sumSubarrayMins907 tmp = new sumSubarrayMins907();

//        int[] A = new int[]{3, 1, 2, 4, 1, 2, 1};
        int[] A = new int[]{3, 1, 2, 4};
        tmp.sumSubarrayMins(A);
    }

    public int sumSubarrayMins(int[] A) {
        int[] prev = new int[A.length];
        int[] next = new int[A.length];
        Stack<Integer> sPrev = new Stack<>();
        Stack<Integer> sNext = new Stack<>();

        for (int i = A.length - 1; i >= 0; i--) {
            while (sPrev.size() > 0 && A[i] <= A[sPrev.peek()]) {
                prev[sPrev.pop()] = i;
            }
            sPrev.push(i);
        }
//        while (sPrev.size() > 0) prev[sPrev.peek()] = sPrev.pop();
        while (sPrev.size() > 0) prev[sPrev.pop()] = -1;


        for (int i = 0; i < A.length; i++) {
            while (sNext.size() > 0 && A[i] <= A[sNext.peek()]) {
                next[sNext.pop()] = i;
            }
            sNext.push(i);
        }
//        while (sNext.size() > 0) next[sNext.peek()] = sNext.pop();
        while (sNext.size() > 0) next[sNext.pop()] = A.length;

        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(next));
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * (i - prev[i]) * (next[i] - i);
        }
        System.out.println(sum);

        return sum;
    }
}
