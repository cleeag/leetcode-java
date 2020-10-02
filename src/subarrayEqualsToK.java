import java.util.HashMap;
import java.util.Map;

public class subarrayEqualsToK {
    public static void main(String[] args) {
//        int[] a = new int[]{2, 1, 3};
//        int s = 2;
//        int[] a = new int[]{0, 4, 3, -1};
//        int s = 2;
        int[] a = new int[]{2, 1, 4};
        int s = 3;
        subarrayEqualsToK tmp = new subarrayEqualsToK();
        System.out.println(tmp.solution(a, s));

    }
    public int solution(int[] A, int S) {
        // write your code in Java SE 8
        Map<Integer, Integer> seen = new HashMap<>();
        int cur = 0;
        int ans = 0;
        seen.put(0, 1);
        for(int a: A){
            cur += a - S;
            if(seen.containsKey(cur)) ans += seen.get(cur);
            seen.put(cur, seen.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}
