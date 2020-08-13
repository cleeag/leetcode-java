public class numOfSubarrays1343 {
    public static void main(String[] args) {
        int[] a = new int[]{2,2,2,2,5,5,5,8};
        int k = 3;
        int th = 4;
        numOfSubarrays1343 tmp = new numOfSubarrays1343();
        System.out.println(tmp.numOfSubarrays(a, k, th));
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int curSum = 0;
        for (int i = 0; i < Math.min(k, arr.length); i++) curSum += arr[i];
        int ans = 0;
        for (int i = 0; i + k < arr.length; i++) {
            if (curSum >= threshold * k) ans++;
            curSum -= arr[i];
            if (i + k < arr.length) curSum += arr[i + k];
        }
        if (curSum >= threshold * k) ans++;
        return ans;
    }
}
