import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class reconstructQueue406 {
    public static void main(String[] args) {
//        int[][] a = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] a = new int[][]{{9, 0}, {7, 0}, {1, 9}, {3, 0}, {2, 7}, {5, 3}, {6, 0}, {3, 4}, {6, 2}, {5, 2}};
        reconstructQueue406 tmp = new reconstructQueue406();
        tmp.reconstructQueue(a);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });
        List<Integer> indices = new LinkedList<>();
        int i = people.length - 1;
        while (i >= 0) {
            int j = i;
            while (j >= 0 && people[j][0] == people[i][0]) j--;
            for (int k = j + 1; k <= i; k++) indices.add(people[k][1], k);
            i = j;
        }
        int[][] ans = new int[people.length][2];
        for (int j = 0; j < indices.size(); j++) ans[j] = people[indices.get(j)];

        System.out.println(Arrays.deepToString(people));
        System.out.println(Arrays.deepToString(ans));
        return ans;
    }
}
