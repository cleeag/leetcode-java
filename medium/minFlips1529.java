public class minFlips1529 {
    public int minFlips(String target) {
        int flips = 0, i = 0;

        while (i < target.length()) {
            if (i == 0) {
                if (target.charAt(0) == '1') flips++;
            } else {
                if (target.charAt(i) != target.charAt(i-1)) flips++;
            }
            i++;
        }
        return flips;
    }
}
