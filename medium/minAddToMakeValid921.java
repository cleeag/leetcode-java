public class minAddToMakeValid921 {
    public int minAddToMakeValid(String S) {
        int left = 0, need = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == ')'){
                if (left > 0) left--;
                else need++;
            } else left++;
        }
        return need + left;
    }
}
