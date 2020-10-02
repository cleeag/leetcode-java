import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class dominoes {
    public static void main(String[] args) {
        int [] A = new int[] {4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5};
        dominoes tmp = new dominoes();
        System.out.println(tmp.solution(A));
    }
    public String solution(int[] A) {
        // write your code in Java SE 8
        return dfs(new int[12], 0, A, new HashSet<>()) ? "Yes" : "No";
    }

    public boolean dfs(int[] arr, int count, int[] A, Set<Integer> seen) {
        if (count == 6) {
            System.out.println(Arrays.toString(arr));
            if (arr[0] == arr[3] && arr[1] == arr[4] && arr[2] == arr[7]
                    && arr[3] == arr[8] && arr[4] == arr[9] && arr[5] == arr[10]) {
                return true;
            } else return false;
        }

        for(int i = 0; i < 6; i++) {
            if (!seen.contains(i)) {
                seen.add(i);
                arr[count * 2] = A[i * 2];
                arr[count * 2 + 1] = A[i * 2 + 1];
                if (dfs(arr, count + 1, A, seen)) return true;

                arr[count * 2] = A[i * 2 + 1];
                arr[count * 2 + 1] = A[i * 2];
                if (dfs(arr, count + 1, A, seen)) return true;

                seen.remove(i);
            }
        }
        return false;
    }
}
