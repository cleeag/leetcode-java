import java.util.*;

public class partitionLabels763 {
    public static void main(String[] args) {
        String  S = "ababcbacadefegdehijhklij";
        partitionLabels763 tmp=  new partitionLabels763();
        tmp.partitionLabels(S);
    }
    public List<Integer> partitionLabels(String S) {
        HashMap<Integer, Integer> charPositions = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            int curChar = S.charAt(i) - 'a';
            charPositions.put(curChar, charPositions.getOrDefault(curChar, 0) + 1);
        }
        Set<Integer> cur = new HashSet<>();
        List<Integer> ans = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (cur.size() == 0 && count > 0) {
                ans.add(count);
                count = 0;
            }
            int curChar = S.charAt(i) - 'a';
            cur.add(curChar);
            charPositions.put(curChar, charPositions.get(curChar) - 1);
            if (charPositions.get(curChar) == 0){
                charPositions.remove(curChar);
                cur.remove(curChar);
            }
            count++;
            System.out.println(cur);
            System.out.println(charPositions);
        }
        ans.add(count);
        System.out.println(ans);
        return ans;
    }


    public List<Integer> partitionLabelsOLD(String S) {
        HashMap<Integer, List<Integer>> charPositions = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!charPositions.containsKey(S.charAt(i) - 'a'))
                charPositions.put(S.charAt(i) - 'a', new LinkedList<>());
            charPositions.get(S.charAt(i) - 'a').add(i);
        }
        Set<Integer> cur = new HashSet<>();
        int count = 0;
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (cur.size() == 0 && count > 0) {
                ans.add(count);
                count = 0;
            }
            cur.add(S.charAt(i) - 'a');
            charPositions.get(S.charAt(i) - 'a').remove(0);
            if (charPositions.get(S.charAt(i) - 'a').size() == 0){
                charPositions.remove(S.charAt(i) - 'a');
                cur.remove(S.charAt(i) - 'a');
            }
            count++;
            System.out.println(cur);
            System.out.println(charPositions);
        }
        System.out.println(ans);
        return ans;
    }
}
