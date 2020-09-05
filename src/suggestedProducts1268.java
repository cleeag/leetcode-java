import java.util.*;

public class suggestedProducts1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            String tmp = searchWord.substring(0, i + 1);
            List<String> sugg = new LinkedList<>();
            while (j < products.length && !products[j].startsWith(tmp)) j++;
            for (int k = 0; k < 3 && j + k < products.length; k++) {
                if (products[j + k].startsWith(tmp)) {
                    sugg.add(products[j + k]);
                }
            }
            ans.add(sugg);
        }
        return ans;
    }
}
