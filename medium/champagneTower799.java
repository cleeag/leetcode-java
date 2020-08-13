public class champagneTower799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tracker = new double[99][99];
        tracker[0][0] = poured;
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (tracker[i][j] > 1){
                    tracker[i+1][j] += (tracker[i][j] - 1) / 2;
                    tracker[i+1][j+1] += (tracker[i][j] - 1) / 2;
                    tracker[i][j] = 1;
                }
            }
        }
        return tracker[query_row][query_glass];
    }
}
