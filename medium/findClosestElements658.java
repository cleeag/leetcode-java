import java.util.LinkedList;
import java.util.List;

public class findClosestElements658 {
    public static void main(String[] args) {
//        int[] a = new int[]{1, 2, 3, 4, 5};
//        int k = 4;
//        int x = 3;

        int[] a = new int[]{1, 3};
        int k = 1;
        int x = 2;

//        int[] a = new int[]{1,1,1,10,10,10};
//        int k = 1;
//        int x = 9;
        findClosestElements658 tmp = new findClosestElements658();
        tmp.findClosestElements(a, k, x);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int[] abs = new int[arr.length];
        int i = 0, j;
        for (; i < arr.length; i++) {
            abs[i] = Math.abs(arr[i] - x);
            if (i > 0 && abs[i] >= abs[i - 1] && arr[i] != arr[i-1]) break;
        }
        List<Integer> ans = new LinkedList<>();
        j = i;
        i -= 2;
        k--;
        int start = i + 1, end = start;
        while (k > 0) {
            if (i < 0 && j >= arr.length) break;
            else if (i < 0) {
                end = j;
                j++;
            } else if (j >= arr.length) {
                start = i;
                i--;
            } else if (Math.abs(arr[i] - x) <= Math.abs(arr[j] - x)) {
                start = i;
                i--;
            } else {
                end = j;
                j++;
            }
            k--;
        }
        for (int l = start; l < end + 1; l++) {
            ans.add(arr[l]);
        }
        System.out.println(ans);
        return ans;
    }
}
