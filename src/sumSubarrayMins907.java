import javax.lang.model.SourceVersion;
import java.util.Arrays;
import java.util.Stack;

public class sumSubarrayMins907 {
    public static void main(String[] args) {
        sumSubarrayMins907 tmp = new sumSubarrayMins907();

//        int[] A = new int[]{3, 1, 2, 4, 1, 2, 1};
//        int[] A = new int[]{3, 1, 2, 4};
        int[] A = new int[] {85};
        System.out.println(tmp.sumSubarrayMins(A));
    }

    public int sumSubarrayMins(int[] A) {
        int[] aa = new int[A.length + 2];
        for (int i = 0; i < A.length; i++) aa[i + 1] = A[i];

        int ans = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < aa.length; i++) {
            while (s.size() > 0 && aa[i] < aa[s.peek()]){
                int cur = s.pop();
                int tmp = aa[cur] * (i - cur) * (cur - s.peek());
                System.out.println(tmp);
                ans += tmp;
            }
            s.add(i);
            System.out.println(s);
            System.out.println(ans);
            System.out.println();
        }
        int mod = (int)1e9 + 7;
        return ans % mod;
    }
}
