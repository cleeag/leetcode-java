import java.util.LinkedList;
import java.util.List;

public class diffWaysToCompute241 {
    public static void main(String[] args) {
        diffWaysToCompute241 tmp = new diffWaysToCompute241();
        String s = "2-1-1";
//        String s = "2*3-4*5"
        tmp.diffWaysToCompute(s);
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<String> inList = new LinkedList<>();
        int i = 0;
        while (i < input.length()) {
            if (!Character.isDigit(input.charAt(i))) {
                inList.add(String.valueOf(input.charAt(i)));
                i++;
            } else {
                int k = 1;
                while (i + k < input.length() && Character.isDigit(input.charAt(i + k))) k++;
                inList.add(input.substring(i, i + k));
                i += k;
            }
        }

        List<Integer> ans = new LinkedList<>();
        dfs(ans, inList, 0);
        System.out.println(ans);
        return ans;
    }

    public void dfs(List<Integer> ans, List<String> inList, int index) {
        if (inList.size() == 1)ans.add(Integer.valueOf(inList.get(0)));
        if (inList.size() == 3) {
            ans.add(compute(inList, 0));
            return;
        }
//        System.out.println(inList);
        for (int i = index; i < inList.size() - 2; i+=2) {
            if (i < 0) continue;
            int res = compute(inList, i);
            List<String> newInList = new LinkedList<>(inList);
            for (int j = 0; j < 3; j++) newInList.remove(i);
            newInList.add(i, String.valueOf(res));
//            System.out.println(newInList);
            dfs(ans, newInList, i - 2);
        }
    }

    public int compute(List<String> inList, int i) {
        int tmp1 = Integer.parseInt(inList.get(i));
        int tmp2 = Integer.parseInt(inList.get(i + 2));
        return switch (inList.get(i + 1)) {
            case "+" -> tmp1 + tmp2;
            case "-" -> tmp1 - tmp2;
            case "*" -> tmp1 * tmp2;
            default -> 0;
        };
    }
}
