import java.util.*;

public class alienOrder269 {
    public static void main(String[] args) {
//        String[] s = new String[]{"wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"};
        String[] s = new String[]{
                "za",
//                "x",
                "zb"
        };
        alienOrder269 tmp = new alienOrder269();
        System.out.println(tmp.alienOrder(s));
    }

    public String alienOrder(String[] words) {
        if (words.length == 1) return words[0];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        int[] inNodes = new int[26];
        Arrays.fill(inNodes, -1);
        q.offer(new int[]{0, words.length});
        int i = 0;
        int size = q.size();
        while (!q.isEmpty()) {
            for (int j = 0; j < size; j++) {
                int[] range = q.poll();
//                System.out.println(Arrays.toString(range));
                int start = range[0];
                int end = start + 1;
                while (start < words.length - 1 && end < range[1]) {
                    System.out.println(start + " " + end + " " + Arrays.toString(range));
                    if (i >= words[start].length()){
                        start++;
                        end++;
                        continue;
                    }
                    int startChar = words[start].charAt(i) - 'a';
                    while (end < range[1] && startChar == words[end].charAt(i) - 'a') end++;
                    if (end == range[1]){
                        if (end - start > 1) q.offer(new int[]{start, end});
                        if (!graph.containsKey(startChar)) graph.put(startChar, new HashSet<>());
                        if (inNodes[startChar] == -1) inNodes[startChar] = -2;
                        break;
                    }
                    int endChar = words[end].charAt(i) - 'a';
                    if (end - start > 1 && !words[start].equals(words[end])) q.offer(new int[]{start, end});
                    if (!graph.containsKey(startChar)) graph.put(startChar, new HashSet<>());
                    if (startChar != endChar) {
                        if (graph.containsKey(endChar) && graph.get(endChar).contains(startChar)) return "";
                        graph.get(startChar).add(endChar);
                        inNodes[endChar] = startChar;
                        if (inNodes[startChar] == -1) inNodes[startChar] = -2;
                    }
                    start = end;
                    end++;
                }
            }
            i++;
            size = q.size();
//            System.out.println(graph);
//            System.out.println(q);
        }
        System.out.println(Arrays.toString(inNodes));
        int start = -1;
        for (int j = 0; j < 26; j++) {
            if (inNodes[j] == -2) {
//                if (start != -1) return "";
                start = j;
            }
        }
        if (start == -1) return "";
        System.out.println(start);
        System.out.println(graph);
        return dfs(graph, start);
    }

    public String dfs(Map<Integer, Set<Integer>> graph, int head) {
        System.out.println(String.valueOf((char) (head + 'a')));
        if (!graph.containsKey(head)) return String.valueOf((char) (head + 'a'));
        String cands = "";
        for (int i : graph.get(head)) {
            String tmp = dfs(graph, i);
            if (tmp.length() > cands.length()) cands = tmp;
        }
        return (char) (head + 'a') + cands;
    }
}
