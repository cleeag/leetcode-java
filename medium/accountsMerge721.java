import java.util.*;

public class accountsMerge721 {
    Set<String> seen = new HashSet<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new LinkedList<>();
        Map<String, String> email2name = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                email2name.put(email, name);
                if (!graph.containsKey(email)) graph.put(email, new HashSet<>());
                graph.get(email).addAll(acc.subList(1, acc.size()));
            }
        }
        System.out.println(email2name);
        System.out.println(graph);

        for (String s : graph.keySet()) {
            if (seen.contains(s)) continue;
            Set<String> itsSet = dfs(graph, s, new HashSet<>());
            List<String> l = new LinkedList<>(itsSet);
            l.sort(String::compareTo);
            l.add(0, email2name.get(s));
            ans.add(l);
        }
        return ans;
    }

    public Set<String> dfs(Map<String, Set<String>> graph, String email, Set<String> path) {
        seen.add(email);
        path.add(email);
        for (String s : graph.get(email)) {
            if (seen.contains(s)) continue;
            path.add(s);
            dfs(graph, s, path);
        }
        return path;
    }
}
