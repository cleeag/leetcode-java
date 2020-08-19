import java.util.*;

public class canReorderDoubled954 {
    public static void main(String[] args) {
        int[] a = new int[]{-2, -4, 2, 4};
        canReorderDoubled954 tmp = new canReorderDoubled954();
        System.out.println(tmp.canReorderDoubled(a));
    }
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> hMap = new HashMap<>();
        for (int num : A) hMap.put(num, hMap.getOrDefault(num, 0) + 1);
        for (int cur : A) {
            int target = 2 * cur;
            if (cur < 0) target = cur / 2;
            System.out.println(cur);
            System.out.println(hMap);
            if (!hMap.containsKey(cur)) continue;
//            if (!hMap.containsKey(target)) return false;

            if (hMap.get(cur) == 1) hMap.remove(cur);
            else hMap.put(cur, hMap.get(cur) - 1);

            if (!hMap.containsKey(target)) return false;

            if (hMap.get(target) == 1) hMap.remove(target);
            else hMap.put(target, hMap.get(target) - 1);
        }
        return true;
    }
}
