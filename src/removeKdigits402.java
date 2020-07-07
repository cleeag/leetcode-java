import java.util.Stack;

public class removeKdigits402 {
    public static void main(String[] args) {
        removeKdigits402 tmp = new removeKdigits402();
//        String a = "1432219";
//        String a = "10200";
        String a = "10";
//        String a = "9";
//        String a = "112";
        tmp.removeKdigits(a, 1);
    }
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Integer> ss = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && ss.size() > 0 && Character.getNumericValue(num.charAt(i)) < ss.peek()){
                ss.pop();
                k--;
            }
            ss.add(Character.getNumericValue(num.charAt(i)));
            System.out.println(ss);
        }
        while (k > 0){
            ss.pop();
            k--;
        }
//        int ans = 0;
//        int i = 1;
//        while (ss.size() > 0){
//            ans += ss.pop() * i;
//            i*=10;
//        }

        String ans = "";
        while (ss.size() > 0)ans = String.valueOf(ss.pop()) + ans;
        while (ans.charAt(0) == '0' && ans.length() >1) ans = ans.substring(1);
        System.out.println(ans);
        return  ans;
    }
}
