import java.util.Arrays;

public class nthSuperUglyNumber313 {
    public static void main(String[] args) {
        int n = 12;
        int[] primes = new int[]{2, 7, 13, 19};

        nthSuperUglyNumber313 tmp = new nthSuperUglyNumber313();
        tmp.nthSuperUglyNumber(n, primes);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        int[] ans = new int[n];
        ans[0] = 1;
        int i = 1;
        while (i < n) {
            int minima = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                minima = Math.min(primes[j] * ans[pointers[j]], minima);
            }
            for (int j = 0; j < primes.length; j++) {
                if (minima == primes[j] * ans[pointers[j]]) pointers[j]++;
            }
            ans[i] = minima;
            i++;
            System.out.println(Arrays.toString(pointers));
            System.out.println(Arrays.toString(ans));
            System.out.println();
        }
        return ans[n - 1];
    }
}
