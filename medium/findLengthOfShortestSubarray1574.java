public class findLengthOfShortestSubarray1574 {
    public static void main(String[] args) {
//        int[] a = new int[]{1, 2, 3};
//        int[] a = new int[]{1, 2, 2};
//        int[] a = new int[]{3};
//        int[] a = new int[]{5, 4, 3, 2, 1};
        int[] a = new int[]{1, 2, 3, 10, 4, 2, 3, 5};
//        int[] a = new int[]{2, 2, 2, 1, 1, 1};
//        int[] a = new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15};
        findLengthOfShortestSubarray1574 tmp = new findLengthOfShortestSubarray1574();
        System.out.println(tmp.findLengthOfShortestSubarray(a));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < arr.length - 1 && arr[i] <= arr[i + 1]) i++;
        while (j > i && arr[j] >= arr[j - 1]) j--;
        if (i == j) return 0;
        int minLen = n - 1;
        System.out.println(i + " " + j);
        minLen = Math.min(n - (i + 1), minLen);
        minLen = Math.min(minLen, j);
        int k = i;
        i = 0;
        while (i <= k && j < n) {
            if (arr[i] <= arr[j]) {
                minLen = Math.min(j - (i + 1), minLen);
                i++;
            } else j++;
        }
        System.out.println(i + " " + j);
        return minLen;
    }
}
