import java.util.Arrays;

public class multiply43 {
    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "456";
//        String n1 = "9";
//        String n2 = "9";
        multiply43 tmp = new multiply43();
        System.out.println(tmp.multiply(n1, n2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] ans = new char[num1.length() + num2.length()];
        Arrays.fill(ans, '0');
        for (int i = n1.length - 1; i >= 0; i--) {
            int carry = 0;
            int ansIdx = 0;
            for (int j = n2.length - 1; j >= 0; j--) {
                ansIdx = ans.length - 1 - (n1.length - 1 - i + n2.length - 1 - j);
                int tmp = (n1[i] - '0') * (n2[j] - '0') + carry + ans[ansIdx] - '0';
                if (tmp >= 10) carry = tmp / 10;
                else carry = 0;
                ans[ansIdx] = (char) ('0' + tmp % 10);
                System.out.println(i + " " + j + " " + tmp + " " + carry);
                System.out.println(Arrays.toString(ans));
            }
            if (carry != 0) ans[ansIdx - 1] = (char) (carry + '0');
        }
        int i = 0;
        for (; i < ans.length; i++) {
            if (ans[i] != '0') break;
        }
        return String.valueOf(Arrays.copyOfRange(ans, i, ans.length));
    }
}
