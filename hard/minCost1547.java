import java.util.Arrays;

public class minCost1547 {
    public static void main(String[] args) {
//        int n = 7;
//        int[] c = new int[]{1, 3, 4, 5};
//        int n = 9;
//        int[] c = new int[]{5, 6, 1, 4, 2};
//        int n = 10;
//        int[] c = new int[]{7, 8, 9, 2, 1};
        int n = 30;
        int[] c = new int[]{18,15,13,7,5,26,25,29};
        minCost1547 tmp = new minCost1547();
        System.out.println(tmp.minCost(n, c));
    }
    public int minCost(int n, int[] cuts) {
        if (cuts.length == 1) return n;
        int[][] dp = new int[cuts.length+2][cuts.length+2];
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, newCuts, 1, newCuts.length - 2);
        for (int i = 0; i < newCuts.length - 2; i++) {
            dp[i][i + 2] = newCuts[i + 2] - newCuts[i];
        }

        for (int k = 2; k < newCuts.length; k++) {
            for (int i = 0; i < newCuts.length - k; i++) {
                int minima = Integer.MAX_VALUE;
                for (int j = 1; j < k; j++) {
                    minima = Math.min(minima,
                            dp[i][i + j]
                                    + dp[i + j][i + k]
                                    + newCuts[i + k] - newCuts[i]);
//                    System.out.println(i + " " + j + " " + k + " " + minima);
                }
                dp[i][i + k] = minima;
            }
//            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
//            System.out.println();
        }
        return dp[0][dp[0].length - 1];
    }
    public int minCostMLE(int n, int[] cuts) {
        if (cuts.length == 1) return n;
        int[][] dp = new int[n + 1][n + 1];
        int[] newCuts = new int[cuts.length + 2];
        newCuts[0] = 0;
        newCuts[newCuts.length - 1] = n;
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, newCuts, 1, newCuts.length - 2);
        for (int i = 0; i < newCuts.length - 2; i++) {
            dp[newCuts[i]][newCuts[i + 2]] = newCuts[i + 2] - newCuts[i];
        }

        for (int k = 2; k < newCuts.length; k++) {
            for (int i = 0; i < newCuts.length - k; i++) {
                int minima = Integer.MAX_VALUE;
                for (int j = 1; j < k; j++) {
                    minima = Math.min(minima,
                            dp[newCuts[i]][newCuts[i + j]]
                                    + dp[newCuts[i + j]][newCuts[i + k]]
                                    + newCuts[i + k] - newCuts[i]);
//                    System.out.println(i + " " + j + " " + k + " " + minima);
                }
                dp[newCuts[i]][newCuts[i + k]] = minima;
            }
//            System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
//            System.out.println();
        }
        return dp[0][dp[0].length - 1];
    }

    public int minCostWRONG(int n, int[] cuts) {
        int[] cutsArr = new int[n + 1];
        for (int cut : cuts) cutsArr[cut] = 1;
        System.out.println(Arrays.toString(cutsArr));
        return binaryCut(cutsArr, 0, n);
    }

    public int binaryCut(int[] cutsArr, int start, int end) {
        if (start + 1 == end) return 0;
        int mid = (start + end) / 2;
        System.out.println(start + " " + end + " " + mid);
        for (int i = 0; mid - i > start && mid + i < end; i++) {
            if (cutsArr[mid + i] == 1)
                return end - start + binaryCut(cutsArr, start, mid + i) + binaryCut(cutsArr, mid + i, end);
            else if (cutsArr[mid - i] == 1)
                return end - start + binaryCut(cutsArr, start, mid - i) + binaryCut(cutsArr, mid - i, end);
        }
        return 0;
    }
}
