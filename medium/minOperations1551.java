public class minOperations1551 {
    public int minOperations(int n) {
        int ans = 0;
        if (n % 2 == 1){
            for (int i = 0; i < n/2; i++) {
                ans += 2 * (i + 1);
            }
        } else {
            for (int i = 0; i < n/2; i++) {
                ans += 2 * i + 1;
            }
        }
        return ans;
    }
}
