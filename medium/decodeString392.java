import javax.print.DocFlavor;
import java.util.Stack;

public class decodeString392 {
    public static void main(String[] args) {
        decodeString392 tmp = new decodeString392();
//        String s = "3[a]2[bc]";
//        String s = "3[a2[c]]";
//        String s = "2[abc]3[cd]ef";
//        String s = "abc3[cd]xyz";
//        String s = "100[leetcode]";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(tmp.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String tmpString = "";
        String ans = "";
        int fullCount = 0;
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                String num = "";
                while (Character.isDigit(s.charAt(i))) num += s.charAt(i++);
                numberStack.push(Integer.parseInt(num));
                continue;
            } else if ( s.charAt(i) == '[') {
                if (!tmpString.equals("") ){
                    stringStack.push(tmpString);
                    tmpString = "";
                }
                fullCount += 1;
            } else if (s.charAt(i) == ']') {
                fullCount -= 1;
                int repeat = numberStack.pop();
                String tmpString2 = "";
                for (int j = 0; j < repeat; j++) tmpString2 += tmpString;
                tmpString = tmpString2;
                if (stringStack.size() > 0 && numberStack.size() == stringStack.size() + 1)
                    tmpString = stringStack.pop() + tmpString;
            } else if (s.charAt(i) != '[') {
                tmpString += s.charAt(i);
            }
            if (numberStack.size() == 0) {
                ans += tmpString;
                tmpString = "";
            }
            i++;
            System.out.println();
            System.out.println(fullCount);
            System.out.println(numberStack);
            System.out.println(tmpString);
            System.out.println(stringStack);
        }
        System.out.println(ans);
        return ans;
    }
}