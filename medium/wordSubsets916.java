import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class wordSubsets916 {
    public static void main(String[] args) {
        String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] B = new String[]{"e","o"};
        wordSubsets916 tmp = new wordSubsets916();
        tmp.wordSubsets(A, B);
    }
    public List<String> wordSubsets(String[] A, String[] B) {

        int[] count = new int[26];
        for (String p : B) {
            int[] tmpCount = new int[26];
            for (int i = 0; i < p.length(); i++) {
                tmpCount[p.charAt(i) - 'a']++;
                count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'] , tmpCount[p.charAt(i) - 'a']);
            }
        }
        List<String> ans = new LinkedList<>();
        outer: for (String s : A) {
            int[] aCount = new int[26];
            for (int i = 0; i < s.length(); i++) aCount[s.charAt(i) - 'a']++;
            for (int i = 0; i < aCount.length; i++) {
                if (aCount[i] < count[i]) continue outer;
            }
            ans.add(s);
        }
        System.out.println(ans);
        return ans;
    }
}
