import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class equationsPossible990 {
    int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; ++i) uf[i] = i;
        for (String eq : equations) {
            if (eq.charAt(1) == '=')
                uf[find(eq.charAt(0) - 'a')] = find(eq.charAt(3) - 'a');
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!')
                if (find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) return false;
        }
        return true;
    }

    public int find(int x) {
        if (x != uf[x]) uf[x] = find(uf[x]);
        return uf[x];
    }

    public boolean equationsPossibleNAIVE(String[] equations) {
        Set<String> disconnects = new HashSet<>();
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (String eq : equations) {
            if (eq.charAt(1) == '!') disconnects.add(eq);
            else {
                char p1 = eq.charAt(0);
                char p2 = eq.charAt(3);
                if (!graph.containsKey(p1)) graph.put(p1, new HashSet<>());
                if (!graph.containsKey(p2)) graph.put(p2, new HashSet<>());
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
            }
        }
        System.out.println(disconnects);
        for (String dis : disconnects) {
            char p1 = dis.charAt(0);
            char p2 = dis.charAt(3);
            if (graph.containsKey(p1) && graph.get(p1).contains(p2)) return false;
            if (graph.containsKey(p2) && graph.get(p2).contains(p1)) return false;
        }
        return true;
    }
}
