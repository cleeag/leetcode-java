public class partitionDisjoint915 {
    public static void main(String[] args) {
        int[] a = new int[]{5, 0, 3, 8, 6};
//        int[] a = new int[]{1,1,1,0,6,12};
//        int[] a = new int[]{1,1};
        partitionDisjoint915 tmp = new partitionDisjoint915();
        tmp.partitionDisjoint(a);
    }

    public int partitionDisjoint(int[] A) {
        int curMax = A[0], nextMax = A[0], len = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < curMax) {
                curMax = nextMax;
                len = i;
            } else if (A[i] >= curMax) nextMax = Math.max(nextMax, A[i]);
        }
        return len + 1;
    }
}
