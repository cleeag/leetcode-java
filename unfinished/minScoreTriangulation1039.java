public class minScoreTriangulation1039 {
    public int minScoreTriangulation(int[] A) {
        if (A.length < 3) return 0;
        else if (A.length == 3) {
            int sum = 1;
            for (int i : A) sum *= i;
            return sum;
        }




    }
}
