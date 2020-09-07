public class treeToDoublyList426 {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node l = treeToDoublyList(root.left);
        Node r = treeToDoublyList(root.right);
        Node head = root;
        Node tail = root;
        if (r != null) {
            tail = r.left;
            root.right = r;
            r.left = root;
        }
        if (l != null) {
            head = l;
            root.left = l.left;
            l.left.right = root;
        }
        head.left = tail;
        tail.right = head;
        System.out.println(head.val);
        System.out.println(head.left);
        System.out.println(head.right);
        System.out.println();
        return head;
    }
}
