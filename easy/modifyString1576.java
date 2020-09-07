public class modifyString1576 {
    public String modifyString(String s) {

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                sb.append(s.charAt(i));
                count = 0;
            }
            else {
                if (i > 0 && s.charAt(i - 1) - 'a' == count) count++;
                if (i < n-1 && s.charAt(i + 1) - 'a' == count) count++;
                if (count > 25) count = 0;
                sb.append((char)('a' + count));
                count++;
            }
        }
        return sb.toString();
    }
}
