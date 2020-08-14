import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class minRemoveToMakeValid1249 {
    public static void main(String[] args) {
//        String s = "lee(t(c)o)de)";
//        String s = "a)b(c)d";
//        String s = "))((";
        String s = "(a(b(c)d)";
        minRemoveToMakeValid1249 tmp = new minRemoveToMakeValid1249();
        tmp.minRemoveToMakeValid(s);
    }

    public String minRemoveToMakeValid(String s) {
        List<Integer> left = new LinkedList<>();
        Set<Integer> right = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left.add(i);
            else if (s.charAt(i) == ')') {
                if (left.size() == 0) right.add(i);
                else left.remove(left.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        right.addAll(left);
        for (int i = 0; i < s.length(); i++) {
            if (right.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
        return sb.toString();
    }
}
