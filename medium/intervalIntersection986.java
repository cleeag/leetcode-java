import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class intervalIntersection986 {
    public static void main(String[] args) {
        int[][] A = new int[][] {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][] {{1,5},{8,12},{15,24},{25,26}};

        intervalIntersection986 tmp = new intervalIntersection986();
        tmp.intervalIntersection(A, B);
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<List<Integer>> ans = new LinkedList<>();

        while (i <= A.length - 1 && j <= B.length - 1) {

            if (!(A[i][1] < B[j][0] || A[i][0] > B[j][1])) {
                int intersecS = Math.max(A[i][0], B[j][0]);
                int intersecF = Math.min(A[i][1], B[j][1]);
                if (ans.size() > 0 && ans.get(ans.size() - 1).get(1) == intersecS) {
                    ans.set(ans.size() - 1, Arrays.asList(ans.get(ans.size() - 1).get(0), intersecF));
                } else {
                    ans.add(Arrays.asList(intersecS, intersecF));
                }
            }

            if (i == A.length - 1) j++;
            else if (j == B.length - 1) i++;
            else if (A[i][1] <= B[j][1]) i++;
            else j++;
            System.out.println(ans);
            System.out.println(Arrays.toString(A[i]));
            System.out.println(Arrays.toString(B[j]));
            System.out.println();
        }
        int[][] res = new int[ans.size()][ans.size()];
        for (int k = 0; k < ans.size(); k++)
            res[k] = new int[]{ans.get(k).get(0), ans.get(k).get(1)};
        return res;
    }
}
