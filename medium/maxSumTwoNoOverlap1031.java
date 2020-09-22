public class maxSumTwoNoOverlap1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int ans = 0;
        int n = A.length;
        int tmpL = L;
        int tmpM = M;
        for(int t = 0; t < 2;t++){
            if (t == 1) {
                L = tmpM;
                M = tmpL;
            }
            int[] dpL = new int[n];
            int sum = 0;
            for(int i = 0; i < L;i++) sum += A[i];
            dpL[L-1] = sum;
            for(int i = L; i < n; i++){
                sum = sum - A[i-L] + A[i];
                dpL[i] = Math.max(sum, dpL[i-1]);
            }
            // System.out.println(Arrays.toString(dpL));

            sum = 0;
            for(int i = L; i < L + M;i++) sum += A[i];
            ans = Math.max(sum + dpL[L-1], ans);
            for(int i = L + M; i < n; i++){
                sum = sum - A[i-M] + A[i];
                ans = Math.max(sum + dpL[i - M], ans);
                // System.out.println(sum);
            }
        }
        return ans;
    }
}
