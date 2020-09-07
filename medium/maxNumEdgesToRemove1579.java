import java.util.Arrays;

public class maxNumEdgesToRemove1579 {
    int[] u;
    int components;

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        u = new int[n + 1];
        Arrays.fill(u, -1);
        components = n;
        int removal = 0;
        removal += buildGraph(3, edges);

        int[] u1 = Arrays.copyOf(u, u.length);
        int componentsCopy = components;
        removal += buildGraph(1, edges);
        if (components != 1) return -1;

        components = componentsCopy;
        u = u1;
        removal += buildGraph(2, edges);
        if (components != 1) return -1;
        return removal;
    }

    public int buildGraph(int type, int[][] edges) {
        int removal = 0;
        for (int[] edge : edges) {
            if (edge[0] != type) continue;
            int x = edge[1], y = edge[2];
            if (find(x) == find(y)) {
                removal++;
                continue;
            }
            union(x, y);
            components--;
        }
        return removal;
    }

    public void union(int x, int y) {
        u[find(x)] = find(y);
    }

    public int find(int num) {
        if (u[num] == -1) u[num] = num;
        if (u[num] != num) u[num] = find(u[num]);
        return u[num];
    }
}
