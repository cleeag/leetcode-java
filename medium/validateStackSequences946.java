import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validateStackSequences946 {
    public static void main(String[] args) {
        int[] pu = new int[] {1,2,3,4,5};
        int[] po = new int[] {4,5,3,2,1};
        validateStackSequences946 tmp = new validateStackSequences946();
        System.out.println(tmp.validateStackSequences(pu, po));
    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int i = 0, j = 0;
        while (i < pushed.length) {
            while (i < pushed.length && pushed[i] != popped[j]) s.push(pushed[i++]);
            j++;
            i++;
            while (s.size() > 0 && s.peek() == popped[j]) {
                s.pop();
                j++;
            }
            System.out.println(i +  " " + j + " " + s);
        }
        return i == j;
    }
}
