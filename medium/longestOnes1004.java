import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class longestOnes1004 {
    public static void main(String[] args) {
        longestOnes1004 tmp = new longestOnes1004();
//        int[] A = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        int[] A = new int[]{};
//        int[] A = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//        int[] A = new int[]{0, 0, 1, 0, 0, 0, 0};
        int[] A = new int[]{1,1,1,0,0,0,1,1,1,1};
//        int[] A = new int[]{0, 0, 1, 1, 1, 0, 0, 0};

        int k = 0;
        tmp.longestOnes(A, k);
    }

    public int longestOnes(int[] A, int K) {
        System.out.println(Arrays.toString(A));
        int i = 0;
        int quota = K;
        Queue<Integer> q = new LinkedList<>();
        int maxLength = 0;
        int curLength = 0;
        for (int j = 0; j < A.length; ) {
            System.out.println(i + " " + j + " " + A[j]);
            System.out.println(q);
            System.out.println(maxLength);
            System.out.println(curLength);
            System.out.println();
            if (A[j] == 0 && quota == 0 && q.size() == 0) {
                while (j < A.length && A[j] == 0) j++;
                if (j == A.length) break;
                i = j;
                curLength = 0;
            }

            if (A[j] == 1) {
                curLength += 1;
            } else if (A[j] == 0 && quota > 0) {
                quota--;
                q.add(j);
                curLength += 1;
            } else if (A[j] == 0 && q.size() > 0) {
                i = q.poll() + 1;
                curLength = j - i + 1;
                q.add(j);
            }
            maxLength = Math.max(maxLength, curLength);
            j++;
        }
        return maxLength;
    }
}
