public class Knapsack {
    int W, n;
    int [] val = new int[50];
    int [] weight = new int[50];
    int [][] ks = new int[50][100];

    public int doKnapsack(int W, int val[], int weight[], int n) {

        for (int i=0; i<=n; i++) {
            for(int j=0; j<=W; j++) {
                if (i==0 || j==0) {
                    ks[i][j] = 0;
                } else if (weight[i-1] > j) {
                    ks[i][j] = ks[i-1][j];
                } else {
                    ks[i][j] = Math.max(val[i-1] + ks[i-1][j-weight[i-1]], ks[i-1][j]);
                }
            }
        }

        return ks[n][W];
    }

    public Knapsack() {
        W = 50;
        n = 6;
        val = new int[]{54, 24, 25, 51, 30, 40};
        weight = new int[]{9, 24, 5, 17, 15, 10};

        System.out.println(doKnapsack(W, val, weight, n));
    }
}
