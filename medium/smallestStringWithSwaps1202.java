import java.util.*;

public class smallestStringWithSwaps1202 {

    int[] u;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        u = new int[s.length()];
        Arrays.fill(u, -1);
        Map<Integer, List<Integer>> unions = new HashMap<>();
        for (List<Integer> p : pairs) union(p.get(0), p.get(1));
        for (int i = 0; i < u.length; i++) {
            int grand = find(i);
            if (!unions.containsKey(grand)) unions.put(grand, new LinkedList<>());
            unions.get(grand).add(i);
        }

        char[] arr = new char[s.length()];
        StringBuilder sb = new StringBuilder();
        for (Integer parent : unions.keySet()) {
            for (Integer son : unions.get(parent)) sb.append(s.charAt(son));
            char[] tmp = sb.toString().toCharArray();
            Arrays.sort(tmp);
            int i = 0;
            for (Integer son : unions.get(parent)) arr[son] = tmp[i++];
            sb.setLength(0);
        }
        return String.valueOf(arr);
    }

    public void union(int x, int y) {
        u[find(x)] = u[find(y)];
    }

    public int find(int num) {
        if (u[num] == -1) u[num] = num;
        if (u[num] != num) u[num] = find(u[num]);
        return u[num];
    }
}
