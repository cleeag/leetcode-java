import java.util.List;

public class leftMostColumnWithOne1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> tmp = binaryMatrix.dimensions();
        int m = tmp.get(0);
        int n = tmp.get(1);
        int minCol = 200;
        for(int i = 0; i < m; i++){
            minCol = Math.min(minCol, bs(binaryMatrix, i, n));
        }
        return minCol == n? -1 : minCol;
    }

    public int bs(BinaryMatrix binaryMatrix, int row, int n){
        int lo = 0, hi = n-1;
        if(binaryMatrix.get(row, hi) == 0) return n;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            // System.out.println(lo + " " + mid + " " + hi);
            if(binaryMatrix.get(row, mid) == 1) hi = mid;
            else lo = mid + 1;
        }
        // System.out.println(lo);
        return lo;
    }
}
