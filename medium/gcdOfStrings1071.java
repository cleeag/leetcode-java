public class gcdOfStrings1071 {
    public static void main(String[] args) {

        gcdOfStrings1071 tmp = new gcdOfStrings1071();
        System.out.println(tmp.gcdOfStrings("AAAAB", "A"));
    }

    public String gcdOfStrings(String str1, String str2) {
        String shorter = str1.length() >= str2.length()? str2 : str1;
        String longer = str1.length() >= str2.length()? str1 : str2;
        int i = 1;
        while (i <= shorter.length()){
            if (shorter.length() % i != 0) {
                i++;
                continue;
            }
            System.out.println(i);
            String div = shorter.substring(0, shorter.length() / i);
            if (devides(shorter, div) && devides(longer, div)) return div;
            i++;
        }
        return "";
    }

    public boolean devides(String s, String div) {
        System.out.println(s + " " + div);
        if (s.length() % div.length() != 0) return false;
        int i = 0;
        while (i < s.length()) {
            if (!s.startsWith(div, i)) return false;
            i += div.length();
        }
        return true;
    }
}
