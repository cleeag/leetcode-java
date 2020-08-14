import java.util.Stack;

public class scoreOfParentheses856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> scores = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') scores.push(-1);
            else if (scores.peek() != -1) {
                int tmp = scores.pop() * 2;
                scores.pop();
                scores.push(tmp);
            } else {
                scores.pop();
                scores.push(1);
            }
            int tmpScore = 0;
            while (scores.size() > 0 && scores.peek() != -1) tmpScore += scores.pop();
            if (tmpScore > 0) scores.push(tmpScore);
        }
        return scores.pop();
    }
}
