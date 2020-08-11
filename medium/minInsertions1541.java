public class minInsertions1541 {
    public static void main(String[] args) {
//        String s = "(()))";
        String s = "))())(";
        minInsertions1541 tmp=  new minInsertions1541();
        System.out.println(tmp.minInsertions(s));
    }
    public int minInsertions(String s) {
        int left = 0, right = 0;
        int leftNeed = 0, rightNeed = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                left++;
                i++;
            }
            else if (i < s.length() - 1 && s.charAt(i) == ')' && s.charAt(i + 1) == ')') {
                if (left > 0) left--;
                else leftNeed++;
                i += 2;
            } else if (left > 0) {
                left--;
                rightNeed++;
                i++;
            } else {
                leftNeed++;
                rightNeed++;
                i++;
            }
        }
        return leftNeed + rightNeed + 2 * left;
    }
}
