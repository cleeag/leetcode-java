public class longestMountain845 {
    public static void main(String[] args) {
//        int[] a = new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
//        int[] a = new int[]{0,1,0};
//        int[] a = new int[]{2, 3, 3, 2, 0, 2};
        int[] a = new int[]{0,0,1,0,0,1,1,1,1,1};
        longestMountain845 tmp = new longestMountain845();
        tmp.longestMountain(a);
    }

    public int longestMountain(int[] A) {
        int maxLen = 0, curLen = 0;
        int dir = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i-1]){
                if (dir == 1)
                    maxLen = Math.max(maxLen, curLen + 1);
                curLen = 0;
                dir = 0;
            }
            if (A[i] > A[i - 1] && dir == 0) curLen++;
            else if (A[i] < A[i - 1] && dir == 0 && curLen > 0) {
                dir = 1;
                curLen++;
                if (i == A.length - 1) curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else if (A[i] < A[i - 1] && dir == 1) {
                curLen++;
                if (i == A.length - 1) curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else if (A[i] >= A[i - 1] && dir == 1) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
                curLen = 0;
                if (A[i] > A[i - 1]) curLen++;
                dir = 0;
            }
            System.out.println(i + " " + curLen + " " + dir + " " + maxLen);
        }
        return maxLen;
    }
}
