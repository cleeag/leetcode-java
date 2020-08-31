public class shortestPalindrome214 {
    public String shortestPalindrome(String s) {
        int i = s.length()-1;
        for (; i >=0 ; i--) {
            if (isPal(s, i)) break;
        }
        System.out.println(i);
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(i+1));
        sb = sb.reverse();
        sb.append(s);
        return s;
    }

    public boolean isPal(String s,  int j){
        int i = 0;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
