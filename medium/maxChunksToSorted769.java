import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class maxChunksToSorted769 {
    public static void main(String[] args) {
//        int[] a = new int[]{4,3,2,1,0};
//        int[] a = new int[]{1,0, 2, 3, 4};
//        int[] a = new int[]{2,0,1};
        int[] a = new int[]{1, 2, 0, 3};
//        int[] a = new int[]{0,1,2,3,4};
        maxChunksToSorted769 tmp = new maxChunksToSorted769();
        tmp.maxChunksToSorted(a);
    }

    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int[] seen = new int[arr.length];
        int front = 0;
        int ans = 0;
        int members = 0;
        int max = 0;
        for (int num : arr) {
            seen[num] = 1;
            if (num > max) {
                if (members == 0) members = num - front;
                else members += num - max - 1;
                max = num;
            } else members--;

            if (members <= 0) {
                ans++;
                members = 0;
                while (front < seen.length && seen[front] == 1) front++;
            }
            if (front == seen.length) break;
            System.out.println(Arrays.toString(seen));
            System.out.println(front + " " + ans + " " + members);
        }
        System.out.println(ans);
        return ans;
    }
}
