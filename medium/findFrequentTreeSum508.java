import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findFrequentTreeSum508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> hMap = new HashMap<>();
        dfs(hMap, root);

        int max = Integer.MIN_VALUE;
        for (Integer value : hMap.values()) max = Math.max(max, value);
        int[] ans = new int[hMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> ent : hMap.entrySet()) if (ent.getValue() == max) ans[i++] = ent.getKey();
        return Arrays.copyOfRange(ans, 0, i);
    }
    public int dfs(Map<Integer, Integer> hMap, TreeNode node){
        if (node == null) return 0;
        int leftVal = 0, rightVal = 0;
        if (node.left != null) leftVal = dfs(hMap, node.left);
        if (node.right != null) rightVal = dfs(hMap, node.right);
        int subTotal = rightVal + leftVal + node.val;
        hMap.put(subTotal, hMap.getOrDefault(subTotal, 0) + 1);
        System.out.println(node.val);
        System.out.println(hMap);
        return subTotal;
    }

}
