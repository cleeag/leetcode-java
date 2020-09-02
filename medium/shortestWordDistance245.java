public class shortestWordDistance245 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int pos1 = -1, pos2 = -1;
        int minDist = n;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2)) pos2 = pos1;
                pos1 = i;
            }
            else if (words[i].equals(word2)) pos2 = i;
            if (pos1 != -1 && pos2 != -1) {
                minDist = Math.min(minDist, Math.abs(pos1 - pos2));
            }
        }
        return minDist;
    }
}
