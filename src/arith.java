import java.util.HashMap;
import java.util.Map;

public class arith {
    public static void main(String[] args) {
        int[]a = new int[]{0, 4, 8, 16};
        int[] b = new int[]{0, 2, 6, 12, 14, 20};
        arith tmp = new arith();
        tmp.maxArithmeticLength(a, b);
    }
    int maxArithmeticLength(int[] a, int[] b) {
        int bptr = 0;
//        int[][] dp = new int[100000][100000];
        Map<Integer, Map<Integer, Integer>> hMap = new HashMap<>();
        int longest = 0;
        for(int i = 0; i < a.length; i++){
            System.out.println(hMap);
            while(bptr < b.length && b[bptr] <= a[i]) {
                int diff2 = a[i] - b[bptr];
                if(!hMap.containsKey(a[i])) hMap.put(a[i], new HashMap<>());
                if(!hMap.containsKey(b[bptr])) hMap.put(b[bptr], new HashMap<>());
                hMap.get(b[bptr]).put(diff2, hMap.get(a[i]).getOrDefault(diff2, 0) + 1);
                hMap.get(a[i]).put(diff2, hMap.get(b[bptr]).getOrDefault(diff2, 0) + 1);
                longest = Math.max(longest, hMap.get(a[i]).get(diff2));
                System.out.println(longest);
                bptr++;
            }
        }
        return longest;

    }
}
