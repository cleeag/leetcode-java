import java.util.*;

public class minAreaRect939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> cords = new HashMap<>();
        for (int[] point : points) {
            if (!cords.containsKey(point[0])) cords.put(point[0], new HashSet<>());
            cords.get(point[0]).add(point[1]);
        }
        System.out.println(cords);
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i+1; j < points.length; j++) {
                int[] p2 = points[j];
                if (p1[0] == p2[0] || p1[1] == p2[1]) continue;
                if (cords.get(p1[0]) .contains(p2[1]) && cords.get(p2[0]).contains(p1[1])){
                    System.out.println(Arrays.toString(p1));
                    System.out.println(Arrays.toString(p2));
                    minArea = Math.min(Math.abs((p2[0] - p1[0]) * (p2[1] - p1[1])), minArea);
                }
            }
        }
        return minArea == Integer.MAX_VALUE? 0 : minArea;
    }
}
