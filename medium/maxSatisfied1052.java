import java.util.Arrays;

public class maxSatisfied1052 {
    public static void main(String[] args) {
//        int[] c = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
//        int[] g = new int[]{0, 1, 0, 1, 0, 1, 0, 1};
//        int x = 3;
        int[] c = new int[]{5,8};
        int[] g = new int[]{0,1};
        int x = 1;
        maxSatisfied1052 tmp = new maxSatisfied1052();
        tmp.maxSatisfied(c, g, x);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
//        System.out.println(Arrays.toString(customers));
//        System.out.println(Arrays.toString(grumpy));
        int n = customers.length;
        int sat = 0;
        for (int k = 0; k < n; k++) {
            if (grumpy[k] == 0) {
                sat += customers[k];
            }
        }
        int i = 0, j = X;
        for (int k = 0; k < j; k++) {
            if (grumpy[k] == 1) sat += customers[k];
        }
        int maxSat = sat;
        while (j < n) {
            if (grumpy[i] == 1) sat -= customers[i];
            if (grumpy[j] == 1) sat += customers[j];
            maxSat = Math.max(sat, maxSat);
            i++;
            j++;
            System.out.println(sat);
        }
        System.out.println(maxSat);
        return maxSat;
    }
}
