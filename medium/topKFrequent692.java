import java.util.*;

public class topKFrequent692 {
    public static void main(String[] args) {
//        String[] w = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
//        String[] w = new String[] {"the", "day", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] w = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequent692 tmp = new topKFrequent692();
        tmp.topKFrequent(w, k);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        Map<Integer, List<String>> count2words = new HashMap<>();
        List<Integer> countList = new LinkedList<>();
        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        for (String word : wordCount.keySet()) {
            if (count2words.get(wordCount.get(word)) != null) count2words.get(wordCount.get(word)).add(word);
            else {
                count2words.put(wordCount.get(word), new LinkedList<>(Collections.singletonList(word)));
                countList.add(wordCount.get(word));
            }
        }
        Collections.sort(countList);
        List<String> ans = new LinkedList<>();
        for (int i = countList.size()-1; i >= 0; i--) {
            List<String> tmpList = count2words.get(countList.get(i));
            Collections.sort(tmpList);
            while (k > 0 && tmpList.size() > 0){
                ans.add(tmpList.get(0));
                tmpList.remove(0);
                k--;
            }
        }
        System.out.println(wordCount);
        System.out.println(count2words);
        System.out.println(countList);
        System.out.println(ans);
        return ans;
    }
}
