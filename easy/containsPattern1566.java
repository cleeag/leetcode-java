public class containsPattern1566 {
    public static void main(String[] args) {
//        int[] n = new int[]{1, 2, 1, 2, 1, 3};
//        int[] n = new int[]{1, 2, 3, 1, 2};
//        int[] n = new int[]{2,2,2,2};
//        int[] n = new int[]{1,2,4,4,4,4};
//        int m = 1,  k = 3;
//        int m = 2;
//        int k = 2;
        int[] n = new int[]{6,3,5,5,5,5,1,5,6,2,5,1,2,5,3,5,1,3,5,5,6,4,1,2};
        int m = 1;
        int k = 5;
        containsPattern1566 tmp = new containsPattern1566();
        System.out.println(tmp.containsPattern(n, m, k));
    }

    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean success = true;
            System.out.println(arr[i]);
            int count = 1;
            while (count < k) {
                System.out.println(count);
                for (int j = 0; j < m; j++) {
                    if (i + j >= n || i + m * count + j >= n) {
                        success = false;
                        break;
                    }
                    if (arr[i + j] == arr[i + m * count + j]) continue;
                    else {
                        success = false;
                        break;
                    }
                }
                if (!success) break;
                count++;
            }
            if (success) {
                System.out.println("suc");
                return true;
            }
        }
        return false;
    }
}
