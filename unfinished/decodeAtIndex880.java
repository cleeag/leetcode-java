import java.util.Stack;

public class decodeAtIndex880 {
    public String decodeAtIndex(String S, int K) {
        Stack<Integer>
    }
    public String decodeAtIndexMLE(String S, int K) {
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))){
                decodedString.append(String.valueOf(decodedString).repeat(Math.max(0, S.charAt(i) - '0' - 1)));
            } else decodedString.append(S.charAt(i));
            if (decodedString.length() > K) break;
            System.out.println(decodedString);
        }
        return String.valueOf(decodedString.charAt(K-1));
    }
}
