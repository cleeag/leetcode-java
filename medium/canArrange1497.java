import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;

public class canArrange1497 {
    public static void main(String[] args) {
        canArrange1497 tmp = new canArrange1497();
//        int[] a = new int[] {1,2,3,4,5,6};
//        int k = 7;
//        int[] a = new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
//        int k = 5;
//        int[] a = new int[] {-10, 10};
//        int k = 2;
        int[] a = new int[] {-1,1,-2,2,-3,3,-4,4};
        int k = 3;

        boolean ans = tmp.canArrange(a, k);
        System.out.println(ans);
    }

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i : arr) {
            int res = i % k >= 0 ? i % k : (i % k) + k;
            if (hmap.containsKey(k - res)) {
                hmap.put(k - res, hmap.get(k - res) - 1);
                if (hmap.get(k - res) == 0) hmap.remove(k - res);
            } else {
                hmap.put(res, hmap.getOrDefault(res, 0) + 1);
            }
            System.out.println(res);
            System.out.println(hmap);
            System.out.println();
        }
        if (hmap.size() == 0) return true;
        else if (hmap.size() == 1 && hmap.containsKey(0)) {
            return hmap.get(0) % 2 == 0;
        } else return false;
    }
}
