import java.util.*;

public class calculate227 {
    public static void main(String[] args) {
//        String s = "30+2*2*3/4";
        String s = "3/2";
//        String s = "1-1+1";
//        String s = "1-1";
        calculate227 tmp = new calculate227();
        tmp.calculate(s);
    }

    public int calculate(String s) {
        List<String> sList = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            String curS = String.valueOf(s.charAt(i));
            if (curS.equals(" ")) {
                i++;
                continue;
            }
            if (!Character.isDigit(s.charAt(i))) {
                sList.add(curS);
                i++;
            } else {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                sList.add(s.substring(i, j));
                i = j;
            }
        }

        Stack<Integer> intStack = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String s1 : sList) {
            if (intStack.size() == 0) {
                intStack.push(Integer.parseInt(s1));
            } else if (Character.isDigit(s1.charAt(0))
                    && operators.size() > 0 && (operators.peek().equals("+") || operators.peek().equals("-"))) {
                if (operators.peek().equals("+"))intStack.push(Integer.parseInt(s1));
                else intStack.push((-Integer.parseInt(s1)));
            } else if (operators.size() > 0 && Character.isDigit(s1.charAt(0))) {
                if (operators.peek().equals("*")) {
                    intStack.push(intStack.pop() * Integer.parseInt(s1));
                } else if (operators.peek().equals("/")) {
                    intStack.push(intStack.pop() / Integer.parseInt(s1));
                }
                operators.pop();
            } else {
                operators.push(s1);
            }
            System.out.println(intStack);
        }
        while (intStack.size() > 1) {
            intStack.push(intStack.pop() + intStack.pop());
            System.out.println(intStack);
        }
        return intStack.peek();
    }
}
