import java.util.LinkedList;
import java.util.List;

public class addTwoNumbers445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> num1=new LinkedList<>(), num2= new LinkedList<>();
        ListNode cur = l1;
        while (cur != null){
            num1.add(cur.val);
            cur = cur.next;
        }
         cur = l2;
        while (cur != null){
            num2.add(cur.val);
            cur = cur.next;
        }

        List<Integer> ans = new LinkedList<>();
        int carry = 0;
        int i = num1.size()-1, j = num2.size()-1;
        while (i >= 0 || j >= 0){
            int tmp =  carry;
            if (i >= 0) tmp += num1.get(i);
            if (j >= 0) tmp += num2.get(j);
            if (tmp > 9){
                carry = 1;
                tmp %= 10;
            } else carry = 0;
            ans.add(0, tmp);
            i--;
            j--;
        }
        if (carry == 1) ans.add(0, 1);
        ListNode head = new ListNode();
        cur = head;
        for (int k = 0; k < ans.size(); k++) {
            cur.val = ans.get(k);
            if (k < ans.size() - 1) cur.next = new ListNode();
            cur = cur.next;
        }
        return head;
    }
}
