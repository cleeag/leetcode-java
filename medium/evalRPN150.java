import java.util.Stack;

public class evalRPN150 {
    public static void main(String[] args) {
        String[] t = new String[] {"2", "1", "+", "3", "*"};
//        String[] t = new String[] {"4", "13", "5", "/", "+"};
//        String[] t = new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        evalRPN150 tmp = new evalRPN150();
        tmp.evalRPN(t);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length()-1))) {
                s.add(Integer.parseInt(token));
            } else {
                int tmp1 = s.pop();
                int tmp2 = s.pop();
                switch (token) {
                    case "+" -> {
                        System.out.println(token);
                        s.add(tmp1 + tmp2);
                    }
                    case "-" -> s.add(tmp2 - tmp1);
                    case "*" -> s.add(tmp2 * tmp1);
                    case "/" -> s.add(tmp2 / tmp1);
                }
            }
            System.out.println(s);
        }
        return s.peek();
    }
}
