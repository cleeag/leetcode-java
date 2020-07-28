import java.util.*;

public class leastBricks554 {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1}
        };
        List<List<Integer>> t = new LinkedList<>();
        for (int[] ints : a) {
            List<Integer> tt = new LinkedList<>();
            for (int anInt : ints) tt.add(anInt);
            t.add(tt);
        }
//        System.out.println(t);
        leastBricks554 tmp = new leastBricks554();
        tmp.leastBricks(t);
    }

    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        PriorityQueue<int[]> p = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        int wallWidth = 0;
        for (int brick : wall.get(0)) wallWidth += brick;
        for (int i = 0; i < wall.size(); i++) p.offer(new int[]{wall.get(i).get(0), i, 0});
        if (p.peek()[0] == wallWidth) return wall.size();

        int curFront = p.peek()[0];
        int maxEnds = Integer.MIN_VALUE;
        while (p.peek()[0] < wallWidth) {
            int cuts = 0;
            while (p.peek()[0] == curFront) {
                cuts++;
                int[] tmp = p.poll();
                System.out.println(Arrays.toString(tmp));
                tmp[2]++;
                tmp[0] += wall.get(tmp[1]).get(tmp[2]);
                p.offer(tmp);
            }
            maxEnds = Math.max(maxEnds, cuts);
            System.out.println(maxEnds);
            curFront = p.peek()[0];
        }
        return wall.size() - maxEnds;
    }
}
