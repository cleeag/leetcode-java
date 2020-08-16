public class minEatingSpeed875 {
    public static void main(String[] args) {
//        int[] p = new int[]{3, 6, 7, 11};
//        int h = 8;
//        int[] p = new int[]{30, 11, 23, 4, 20};
//        int h = 6;
//        int h = 5;
        int[] p = new int[]{312884470};
        int h = 968709470;

        minEatingSpeed875 tmp = new minEatingSpeed875();
        tmp.minEatingSpeed(p, h);
    }

    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = lo;
        for (int i = 0; i < piles.length; i++) hi = Math.max(hi, piles[i]);

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            boolean can = canEat(piles, mid, H);
            System.out.println(lo + " " + hi + " " + mid + " " + can);
            if (can) hi = mid;
            else lo = mid;
        }
        System.out.println(hi);
        if (canEat(piles, lo, H)) return lo;
        return hi;
    }

    public boolean canEat(int[] piles, int speed, int H) {
        double time = 0;
        for (int pile : piles) {
            double tmp = ((double) pile) / speed;
            if (tmp > (int) tmp) time += (int) tmp + 1;
            else time += tmp;
        }
        return time <= (double) H;
    }
}
