public class countSubstrings647 {

    public int countSubstrings(String s) {
        if(s.length()==0)
            return 0;

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countIt(s, i, i);
            count += countIt(s, i, i + 1);
        }
        return count;
    }

    public int countIt(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }

        return count;
    }
}
