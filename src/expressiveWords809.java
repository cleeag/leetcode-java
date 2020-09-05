import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class expressiveWords809 {
    public static void main(String[] args) {
//        String s = "heeellooo";
//        String[] ws = new String[]{"hello", "hi", "helo"};
//        String s ="tttttllll";
//        String[] ws = new String[]{"tl","tll","ttll","ttl"};
        String s = "sass";
        String[] ws = new String[]{"sa"};
        expressiveWords809 tmp = new expressiveWords809();
        tmp.expressiveWords(s, ws);
    }

    public int expressiveWords(String S, String[] words) {
        List<int[]> charCount = build(S);
        int ans = 0;
        outer :
        for (String word : words) {
            List<int[]> count = build(word);
            if (charCount.size() != count.size()) continue outer;
            for (int i = 0; i < charCount.size(); i++) {
                int[] tmp1 = charCount.get(i);
                int[] tmp2 = count.get(i);
                if (tmp1[0] != tmp2[0] || tmp1[1] < tmp2[1] || (tmp1[1] == 2 && tmp2[1] != 2)) continue outer;
            }
            ans++;
        }
        System.out.println(ans);
        return ans;

    }

    public List<int[]> build(String S){
        List<int[]> charCount = new LinkedList<>();
        if (S.length() == 0) return charCount;
        int l = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                charCount.add(new int[]{S.charAt(i - 1) - 'a', l});
                l = 0;
            }
            l++;
        }
        charCount.add(new int[]{S.charAt(S.length() - 1) - 'a', l});
        return charCount;
    }
}
