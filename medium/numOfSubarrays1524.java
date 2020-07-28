public class numOfSubarrays1524 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
//        int[] a = new int[]{2, 4, 6};
//        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        numOfSubarrays1524 tmp = new numOfSubarrays1524();
        System.out.println(tmp.numOfSubarrays(a));
    }

    public int numOfSubarrays(int[] arr) {
        int sum = 0, evens = 1, odds = 0, ans = 0;
        double mod = 1e9 + 7;
        for (int num : arr) {
            sum += num;
            if (sum % 2 == 0) {
                ans = (int)((ans + odds) % mod);
                evens = (int)((evens + 1) % mod);
            }
            else {
                ans = (int)((ans + evens) % mod);
                odds = (int)((odds + 1) % mod);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public int numOfSubarraysTLE(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (int) ((ans + dfs(arr, 0, i)) % (1e9 + 7));
        }
        System.out.println(ans);
        return ans;
    }

    public int dfs(int[] arr, int cur, int idx) {
        if (idx >= arr.length) return 0;
        cur = cur == arr[idx] % 2 ? 0 : 1;
        int res = cur == 0 ? 0 : 1;
        res = (int) ((res + dfs(arr, cur, idx + 1)) % (1e9 + 7));
        return res;
    }
}
