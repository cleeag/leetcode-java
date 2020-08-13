import java.util.*;

public class maxRepOpt11156 {
    public static void main(String[] args) {
//        String s = "ababab";
//        String s = "accbaaab";
        String s = "aabaa";
        maxRepOpt11156 tmp = new maxRepOpt11156();
        tmp.maxRepOpt1(s);
    }

    public int maxRepOpt1(String text) {
        Map<Integer, Integer> hMap = new HashMap<>();
        List<int[]> l = new LinkedList<>();
        int curLen = 0;
        int ans = 0;
        for (int i = 0; i < text.length(); i++) {
            hMap.put(text.charAt(i) - 'a', hMap.getOrDefault(text.charAt(i) - 'a', 0) + 1);
            if (i > 0 && text.charAt(i) != text.charAt(i - 1)) {
                l.add(new int[]{text.charAt(i - 1) - 'a', curLen});
                curLen = 1;
            } else curLen++;
            ans = Math.max(ans, curLen);
        }
        l.add(new int[]{text.charAt(text.length() - 1) - 'a', curLen});
        for (int i = 0; i < l.size(); i++) {
            int[] tmp = l.get(i);
            if (hMap.get(tmp[0]) > tmp[1]) ans = Math.max(ans, tmp[1] + 1);
            if (i != 0 && i != l.size() - 1 && tmp[1] == 1 && l.get(i - 1)[0] == l.get(i + 1)[0]) {
                if (hMap.get(l.get(i - 1)[0]) > l.get(i - 1)[1] + l.get(i + 1)[1])
                    ans = Math.max(ans, l.get(i - 1)[1] + l.get(i + 1)[1] + 1);
                else
                    ans = Math.max(ans, l.get(i - 1)[1] + l.get(i + 1)[1]);
            }
        }
        for (int i = 0; i < l.size(); i++) System.out.println(Arrays.toString(l.get(i)));
        System.out.println(hMap);
        System.out.println(ans);
        return ans;
    }
}
