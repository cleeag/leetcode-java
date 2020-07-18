public class flatten430 {
    public Node flatten(Node head) {
        if (head == null) return null;
        dfs(head);
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val);
            if (tmp.prev != null) System.out.println(tmp.prev.val);
            if (tmp.next != null) System.out.println(tmp.next.val);
            System.out.println();
            tmp = tmp.next;
        }
        return head;
    }

    public Node dfs(Node head){
        System.out.println(head.val);
        if (head.child == null && head.next == null) return head;
        else if (head.child == null) return dfs(head.next);
        else{
            Node tail = dfs(head.child);
            Node orgNext = head.next;
            head.next  = head.child;
            head.child.prev = head;
            head.child = null;
            if (orgNext != null){
                tail.next = orgNext;
                orgNext.prev = tail;
                head = orgNext;
            }
            return dfs(head);
        }
    }
}
