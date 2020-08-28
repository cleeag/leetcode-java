import java.util.HashMap;
import java.util.Map;

public class copyRandomList138 {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> hMap = new HashMap<>();
        Map<Integer, Node> copyMap = new HashMap<>();
        Node cur = head.next;
        Node copyHead = new Node(head.val);
        Node copyPtr = copyHead;
        hMap.put(head, 0);
        copyMap.put(0, copyHead);
        int i = 1;
        while (cur != null) {
            copyPtr.next = new Node(cur.val);
            hMap.put(cur, i);
            copyMap.put(i, copyPtr.next);
            cur = cur.next;
            i++;
            copyPtr = copyPtr.next;
        }
        cur = head;
        copyPtr = copyHead;
        while (cur != null) {
            if (cur.random != null) {
                int idx = hMap.get(cur.random);
                copyPtr.random = copyMap.get(idx);
            }
            cur = cur.next;
            copyPtr = copyPtr.next;
        }
        return copyHead;
    }
}

