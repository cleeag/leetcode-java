public class maxScore1423 {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int i = 0, j = 0;
        int sum = 0, minSum = Integer.MAX_VALUE, totalSum = 0;
        while (j < n) {
            if (j - i + 1 > n - k) {
                sum -= cardPoints[i++];
                minSum = Math.min(sum, minSum);
            }
            totalSum += cardPoints[j];
            sum += cardPoints[j++];
        }
        return totalSum - minSum;
    }
}
