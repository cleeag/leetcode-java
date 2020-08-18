import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class removeSubfolders1233 {
    public static void main(String[] args) {
//        String[] f = new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"};
//        String[] f = new String[]{"/a","/a/b/c","/a/b/d"};
        String[] f = new String[]{"/a/b/c","/a/b/ca","/a/b/d"};
        removeSubfolders1233 tmp = new removeSubfolders1233();
        tmp.removeSubfolders(f);
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);;
        int[] tracker = new int[folder.length];
        char curStart = folder[0].charAt(1);
        List<String> ans = new LinkedList<>();
        int i = 0;
        while (i < folder.length) {
            curStart = folder[i].charAt(1);
            int j = i + 1;
            while (j < folder.length && folder[j].charAt(1) == curStart) j++;
            for (int k = i; k < j; k++) {
                if (tracker[k] == 1) continue;
                for (int l = k + 1; l < j; l++) {
                    if (tracker[l] == 1) continue;
                    if (folder[l].startsWith(folder[k]) && folder[l].charAt(folder[k].length()) == '/'){
                        tracker[l] = 1;
                    }
                }
            }
            i = j;
        }
        for (int j = 0; j <folder.length ; j++) {
            if (tracker[j] ==0) ans.add(folder[j]);
        }
        System.out.println(ans);
        return ans;
    }
}
