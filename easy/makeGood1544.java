import java.util.Stack;

public class makeGood1544 {
    public static void main(String[] args) {
        String s = "leEeetcode";
        makeGood1544 tmp = new makeGood1544();
        tmp.makeGood(s);
    }
    public String makeGood(String s) {
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (indices.size() == 0) indices.push(i);
            else{
                char tmp = s.charAt(i);
                if (Character.isUpperCase(tmp)){
                    if (tmp - 'A' == s.charAt(indices.peek()) - 'a') indices.pop();
                    else indices.push(i);
                } else {
                    if (tmp - 'a' == s.charAt(indices.peek()) - 'A') indices.pop();
                    else indices.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (indices.size() > 0) sb.insert(0, s.charAt(indices.pop()));
        return sb.toString();
    }
}
