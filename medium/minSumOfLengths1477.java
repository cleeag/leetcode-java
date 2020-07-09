import java.util.HashMap;
import java.util.Map;

public class minSumOfLengths1477 {
    public static void main(String[] args) {
//        int[] a = new int[] {3,2,2,4,3};
//        int t = 3;
//        int[] a = new int[] {7,3,4,7};
//        int t = 7;
//        int[] a = new int[] {4,3,2,6,2,3,4};
//        int t = 6;
        int[] a = new int[] {3,1,1,1,5,1,2,1};
        int t = 3;


        minSumOfLengths1477 tmp = new minSumOfLengths1477();
        System.out.println(tmp.minSumOfLengths(a, t));
    }
    public int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> hMap = new HashMap<>();
        int[] newArr = new int[arr.length + 1];
        newArr[0] = 0;
        int sum = 0;
        hMap.put(sum, 0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            hMap.put(sum, i + 1);
            newArr[i + 1] = arr[i];
        }
        int leftMin = Integer.MAX_VALUE;
        sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < newArr.length; i++) {
            sum += newArr[i];
            if (hMap.get(sum - target) != null) {
                leftMin = Math.min(leftMin, i - hMap.get(sum - target));
            }
            if (leftMin != Integer.MAX_VALUE && hMap.get(sum + target) != null){
                res = Math.min(res, leftMin + hMap.get(sum + target) - i);
            }
            System.out.println(leftMin);
        }
        return res == Integer.MAX_VALUE? -1:res;
    }
}
