import java.util.*;

public class calcEquation399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0), end = equations.get(i).get(1);
            if (!graph.containsKey(start)) graph.put(start, new HashMap<>());
            if (!graph.containsKey(end)) graph.put(end, new HashMap<>());
            graph.get(start).put(end, values[i]);
            graph.get(end).put(start, 1 / values[i]);
            graph.get(start).put(start, 1.0);
            graph.get(end).put(end, 1.0);
        }
//        System.out.println(graph);

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String start = q.get(0), end = q.get(1);
//            System.out.println(start + " " + end);
//            System.out.println(Arrays.toString(ans));
            if (!graph.containsKey(start) || !graph.containsKey(end)) ans[i] = -1;
            else if (graph.get(start).containsKey(end)) ans[i] = graph.get(start).get(end);
            else {
                Queue<String> qu = new LinkedList<>();
                Set<String> s = new HashSet<>();
                qu.add(start);
                boolean done = false;
                while (!qu.isEmpty() && !done) {
//                    System.out.println(qu);
                    String curNode = qu.poll();
                    s.add(curNode);
                    for (String nextNode : graph.get(curNode).keySet()) {
                        if (nextNode.equals(curNode))
                            continue;
                        else if (nextNode.equals(end)) {
                            ans[i] = graph.get(start).get(curNode) * graph.get(curNode).get(nextNode);
                            graph.get(start).put(end, ans[i]);
                            done = true;
                            break;
                        } else if (!graph.get(start).containsKey(nextNode)) {
                            double start2cur = graph.get(start).get(curNode);
                            double cur2next = graph.get(curNode).get(nextNode);
                            graph.get(start).put(nextNode, start2cur * cur2next);
                            graph.get(nextNode).put(start, 1 / graph.get(start).get(nextNode));
                        }
                        if (!s.contains(nextNode)) qu.add(nextNode);
                    }
                }
                if (!done) ans[i] = -1;
            }
        }
        return ans;
    }
}
