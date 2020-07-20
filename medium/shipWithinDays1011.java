import java.lang.reflect.WildcardType;

public class shipWithinDays1011 {
    public static void main(String[] args) {
//        int[] weights = {1,2,3,4,5,6,7,8,9,10};
//        int D = 5;
//        int[] weights = {3,2,2,4,1,4};
//        int D = 3;
//        int[] weights = {1,2,3,1,1};
//        int D = 4;
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int D = 10;
        shipWithinDays1011 tmp = new shipWithinDays1011();
        System.out.println(tmp.shipWithinDays(weights, D));
//        tmp.possible(13, weights, D);
    }

    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int w : weights) sum += w;

        int low = 0, high = sum, mid = (high + low) / 2;
        while (low < high - 1) {
            System.out.println(low + " " + high);
            mid = (high + low) / 2;
            if (possible(mid, weights, D)) high = mid;
            else low = mid;
        }
        if (possible(low, weights, D)) return low;
        else return high;
    }

    public boolean possible(int cap, int[] weights, int D) {
        int i = 0;
        int curCap = cap;
        while (i < weights.length && D > 0) {
            if (cap < weights[i]) return false;
            if (curCap - weights[i] < 0 && D > 1) {
                D--;
                curCap = cap;
            }
            curCap -= weights[i];
            i++;
//            System.out.println(i + " " + curCap + " " + D);
        }
        System.out.println(cap);
        System.out.println(i == weights.length && curCap >= 0);
        System.out.println();
        return i == weights.length && curCap >= 0;
    }
}
