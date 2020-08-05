import java.util.Stack;

public class maximumSwap670 {
    public static void main(String[] args) {
//        int num = 2736;
        int num = 9973;
//        int num = 98368;
        maximumSwap670 tmp = new maximumSwap670();
        System.out.println(tmp.maximumSwap(num));
    }

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        if (digits.length < 2) return num;
        int max = digits.length - 1;
        int reversePoint1 = digits.length - 1, reversePoint2 = digits.length - 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] < digits[max]) {
                reversePoint1 = i;
                reversePoint2 = max;
            }
            else if (digits[i] > digits[max]) {
                max = i;
            }
        }
        char tmp = digits[reversePoint2];
        digits[reversePoint2] = digits[reversePoint1];
        digits[reversePoint1] = tmp;
        return Integer.parseInt(new String(digits));
    }
}
