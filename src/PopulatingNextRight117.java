import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

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

public class PopulatingNextRight117 {

    public Node connect(Node root) {
        List<Node> curLayer = new LinkedList<>();
        if (root != null) curLayer.add(root);
        while (!curLayer.isEmpty()) {
            List<Node> newLayer = new LinkedList<>();
            for (int i = 0; i < curLayer.size() - 1; i++) {
                curLayer.get(i).next = curLayer.get(i + 1);
                if (curLayer.get(i).left != null) newLayer.add(curLayer.get(i).left);
                if (curLayer.get(i).right != null) newLayer.add(curLayer.get(i).right);
            }
            if (curLayer.get(curLayer.size() - 1).left != null)
                newLayer.add(curLayer.get(curLayer.size() - 1).left);
            if (curLayer.get(curLayer.size() - 1).right != null)
                newLayer.add(curLayer.get(curLayer.size() - 1).right);
            curLayer = newLayer;
        }
        return root;
    }
}


