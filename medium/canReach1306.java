import java.util.Arrays;

public class canReach1306 {
    public static void main(String[] args) {
//        int[] a = new int[]{4,2,3,0,3,1,2};
//        int start = 3;
        int[] a = {3,0,2,1,2};
        int start = 2;
        canReach1306 tmp = new canReach1306();
        System.out.println(tmp.canReach(a, start));
    }

    public boolean canReach(int[] arr, int start) {
        int[] been = new int[arr.length];
        return dfs(arr, start + arr[start], been) || dfs(arr, start - arr[start], been);
    }

    public boolean dfs(int[] arr, int index, int[] been){
        if (index < 0 || index >= arr.length || been[index] == 1) return false;
        if (arr[index] == 0) return true;
        been[index] = 1;
        return dfs(arr, index + arr[index], been.clone()) || dfs(arr, index - arr[index], been.clone());
    }
}
