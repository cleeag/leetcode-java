import java.util.Arrays;

public class maxDistance1552 {
    public static void main(String[] args) {
//        int[] p = new int[]{1, 2, 3, 4, 7};
//        int m = 3;
//        int[] p = new int[]{5,4,3,2,1,1000000000};
//        int m = 2;
//        int[] p = new int[]{1, 2, 3, 4, 5, 12};
//        int m = 4;
        int[] p = new int[]{79,74,57,22};
        int m = 4;
        maxDistance1552 tmp = new maxDistance1552();
        System.out.println(tmp.maxDistance(p, m));
    }

    public int maxDistance(int[] position, int m) {
//        if (m == position.length) return 1;
        Arrays.sort(position);

        int hi = (position[position.length - 1] - position[0]) / (m - 1);
        int lo = 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            boolean canPut = can(position, mid, m);
            System.out.println(lo + " " + mid + " " + hi + " " + canPut);
            if (canPut) lo = mid;
            else hi = mid;
        }
        if (can(position, hi, m)) return hi;
        return lo;
    }

    public boolean can(int[] p, int f, int m) {
        int nextP = p[0];
        int count = 1;
        int i = 0;
        while (i < p.length) {
            if (p[i] >= nextP + f) {
                nextP = p[i];
                count++;
            }
            i++;
        }
        return count >= m;
    }
}
