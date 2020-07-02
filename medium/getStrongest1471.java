import java.util.Arrays;

public class getStrongest1471 {
    public static void main(String[] args) {
        getStrongest1471 tmp = new getStrongest1471();
        int[] a = new int[]{2, 1, 3, 4, 5};
//        int[] a = new int[]{6,7,11,7,6,8};
//        int[] a = new int[]{6,-3,7,2,11};
//        int[] a = new int[]{-7, 22, 17, 3};
        int k = 2;
        tmp.getStrongest(a, k);

    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];

        int[] ans = new int[k];
        int high = arr.length - 1, low = 0;
        while (k > 0) {
            if (arr[high] - m >= m - arr[low]) {
                ans[ans.length - k] = arr[high];
                high--;
            } else {
                ans[ans.length - k] = arr[low];
                low++;
            }
            k--;
        }
        return arr;
    }
}
