public class maxScoreSightseeingPair1014 {
    public static void main(String[] args) {
//        int[] A = {1, 2, 2};
        int[] A = {8,1,5,2,6};
        maxScoreSightseeingPair1014 tmp = new maxScoreSightseeingPair1014();
        tmp.maxScoreSightseeingPair(A);

    }

    public int maxScoreSightseeingPair(int[] A) {
        int i = 0;
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            System.out.println(i);
            max = Math.max(max, A[i] + A[j] + i - j);
            if (A[i] + i - j < A[j]) i = j;
        }
        System.out.println(max);
        return max;
    }
}
