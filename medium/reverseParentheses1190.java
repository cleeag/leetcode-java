import java.util.Stack;

public class reverseParentheses1190 {
    public static void main(String[] args) {
//        String s = "(ed(et(oc))el)";
        String s = "a(bcdefghijkl(mno)p)q";
        reverseParentheses1190 tmp = new reverseParentheses1190();
        tmp.reverseParentheses(s);
    }
    public String reverseParentheses(String s) {
        Stack<String> str = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') str.push("(");
            else if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (str.size() > 0 && !str.peek().equals("(")) {
                    sb.insert(0, str.pop());
                }
                str.pop();
                str.push(sb.reverse().toString());
            } else {
                str.push(String.valueOf(s.charAt(i)));
            }
            System.out.println(str);
        }
        StringBuilder sb = new StringBuilder();
        while (str.size() > 0) sb.insert(0, str.pop());
        return sb.toString();
    }
}
