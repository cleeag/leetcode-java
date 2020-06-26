import java.util.Arrays;

public class subarraysDivByK974 {
    public static void main(String[] args) {

//        int[] a = new int[]{4, 5, 0, -2, -3, 1};
        int[] a = new int[]{5};
        int k = 9;
        subarraysDivByK974 tmp = new subarraysDivByK974();
        tmp.subarraysDivByK(a, k);
    }

    public int subarraysDivByK(int[] A, int K) {
        if (A.length == 0) return 0;

        int[] sumArray = new int[A.length];
        sumArray[0] = A[0];
        for (int i = 1; i < A.length; i++) sumArray[i] = sumArray[i-1] + A[i];
        System.out.println(Arrays.toString(sumArray));

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            System.out.println();
            int sum = sumArray[i];
            for (int j = 0; j < i + 1; j++) {
                System.out.println(i + " " + j + " " + sum);
                if (sum % K == 0) {
                    count += 1;
                }
                sum -= A[j];
            }
        }
        System.out.println(count);
        return count;
    }
}
