public class wiggleMaxLength376 {
    public static void main(String[] args) {
//        int[] m = new int[]{1,7,4,9,2,5};
//        int[] m = new int[]{1,17,5,10,13,15,10,5,16,8};
        int[] m = new int[]{1,2,3,4,5,6,7,8,9};
        wiggleMaxLength376 tmp = new wiggleMaxLength376();
        tmp.wiggleMaxLength(m);
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int len = 1;
        int dir = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1] && dir != 1) {
                len++;
                dir = 1;
            }
            else if (nums[i] < nums[i - 1] && dir != -1) {
                len++;
                dir = -1;
            }
        }
        System.out.println(len);
        return len;
    }
}
