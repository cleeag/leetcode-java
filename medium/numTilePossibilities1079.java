import java.util.Arrays;

public class numTilePossibilities1079 {
    public static void main(String[] args) {
        String s = "AAABBC";
        numTilePossibilities1079 tmp = new numTilePossibilities1079();
        tmp.numTilePossibilities(s);
    }

    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return dfs(count);
    }

    public int dfs(int[] count) {
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            sum++;
            count[i]--;
            sum += dfs(count);
            count[i]++;
        }
        return sum;
    }
}
