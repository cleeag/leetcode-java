import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulatingNextRight116 {

    public Node connect(Node root) {
        List<Node> curLayer = new LinkedList<>();
        curLayer.add(root);
        while (curLayer.get(0) != null) {
            List<Node> newLayer = new LinkedList<>();
            for (int i = 0; i < curLayer.size() - 1; i++) {
                curLayer.get(i).next = curLayer.get(i + 1);
                newLayer.add(curLayer.get(i).left);
                newLayer.add(curLayer.get(i).right);
            }
            newLayer.add(curLayer.get(curLayer.size() - 1).left);
            newLayer.add(curLayer.get(curLayer.size() - 1).right);
            curLayer = newLayer;
        }
        return root;
    }
}


