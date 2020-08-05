import java.util.Stack;

public class checkValidString678 {
    public static void main(String[] args) {
//        String s = "(*)";
        String s = "(((******))";
        checkValidString678 tmp = new checkValidString678();
        System.out.println(tmp.checkValidString(s));
    }

    public boolean checkValidString(String s) {
        Stack<Integer> leftP = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') leftP.push(i);
            else if (s.charAt(i) == '*') stars.push(i);
            else {
                if (leftP.size() == 0 && stars.size() == 0) return false;
                if (leftP.size() > 0) leftP.pop();
                else stars.pop();
            }
//            System.out.println(leftP);
        }
        while (leftP.size() > 0) {
            if (stars.size() == 0||stars.peek() < leftP.peek())return false;
            leftP.pop();
            stars.pop();
        }
        return true;
    }
}
