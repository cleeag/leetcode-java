public class threeConsecutiveOdds1550 {
    public static void main(String[] args) {
//        int [] a = new int[]{2,6,4,1};
//        int [] a = new int[]{1,2,34,3,4,5,7,23,12};
        int [] a = new int[]{};
        threeConsecutiveOdds1550 tmp = new threeConsecutiveOdds1550();
        System.out.println(tmp.threeConsecutiveOdds(a));
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) count = 0;
            else count++;
            if (count >= 3) return true;
            System.out.println(count);
        }
        return false;
    }
}
