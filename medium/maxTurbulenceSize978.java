public class maxTurbulenceSize978 {
    public static void main(String[] args) {
        int[] a = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
//        int[] a = new int[] {4, 8, 12, 16};
//        int[] a = new int[] {8,8,9,10,6,8,2,4,2,2,10,6,6,10,10,2,3,5,1,2,10,4,2,0,9,4,9,3,0,6,3,2,3,10,10,6,4,6,4,4,2,5,1,4,1,1,9,8,9,5,3,5,5,4,5,5,6,5,3,3,7,2,0,10,9,7,7,3,5,1,0,9,6,3,1,3,4,4,3,6,3,2,1,4,10,2,3,4,4,3,6,7,6,2,1,7,0,6,8,10};
//        int[] a = new int[] {0,8,45,88,48,68,28,55,17,24};
//        int[] a = new int[]{100, 100, 100};
        maxTurbulenceSize978 tmp = new maxTurbulenceSize978();
        System.out.println(tmp.maxTurbulenceSize(a));
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) return A.length;
        else if (A.length == 2) {
            if (A[0] != A[1]) return 2;
            else return 1;
        }
        int maxL = 0;
        int cur = 1;
        for (int i = 1; i < A.length; i++) {
            if (i == 1) {
                if (A[i - 1] != A[i]) maxL = Math.max(maxL, ++cur);
                continue;
            }
            if ((A[i] <= A[i - 1] && A[i - 1] <= A[i - 2]) || (A[i] >= A[i - 1] && A[i - 1] >= A[i - 2])) {
                maxL = Math.max(maxL, cur);
                cur = 2;
                if (A[i] == A[i - 2]) cur = 1;
            } else {
                cur++;
                maxL = Math.max(maxL, cur);
            }
            System.out.println(A[i] + " " + cur + " " + maxL);
        }
        maxL = Math.max(maxL, cur);
        return maxL;
    }
}
