import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class nextLargerNodes1019 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> values = new Stack<>();
        Stack<Integer> indices = new Stack<>();
        int i = 0;
        int[] ans = new int[10000];
        ListNode cur = head;
        while (cur!= null){
            while (values.size() > 0 && cur.val > values.peek()) {
                ans[indices.pop()] = cur.val;
                values.pop();
            }
            values.add(cur.val);
            indices.add(i);
            cur = cur.next;
            i++;
            System.out.println(values);
            System.out.println(indices);
        }
        while (indices.size() > 0){
            ans[indices.pop()] = 0;
        }
        return Arrays.copyOfRange(ans, 0, i);
    }
}
