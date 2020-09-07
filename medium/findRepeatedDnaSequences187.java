import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class findRepeatedDnaSequences187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        Set<String> rep = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String tmp = s.substring(i, i + 10);
            if (rep.contains(tmp)) ans.add(tmp);
            else rep.add(tmp);
        }
        return new LinkedList<>(ans);
    }
}
