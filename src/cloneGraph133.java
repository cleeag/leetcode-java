import java.util.*;

public class cloneGraph133 {
    Map<Integer, Node> hMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node cloneNode = new Node(node.val);
        dfs(node, cloneNode);
        return cloneNode;
    }

    public void dfs(Node node, Node cloneNode) {
        System.out.println(node.val);
        hMap.put(cloneNode.val, cloneNode);
        for (Node adj : node.neighbors) {
            if (hMap.containsKey(adj.val)) {
                cloneNode.neighbors.add(hMap.get(adj.val));
            } else {
                Node clonedAdj = new Node(adj.val);
                cloneNode.neighbors.add(clonedAdj);
                dfs(adj, clonedAdj);
            }
        }
    }

}
