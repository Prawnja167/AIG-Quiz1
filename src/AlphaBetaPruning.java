import java.util.Scanner;

public class AlphaBetaPruning {
    final int INF = Integer.MAX_VALUE;
    int [] value = new int[50];
    Scanner scan = new Scanner(System.in);

    public int doAlphaBetaPruning(int alpha, int beta, int level, int index) {
        if (level == 3) {
            return value[index];
        } else if (level%2 == 0) {
            int currBest = -INF;
            for (int i=0; i<=1; i++) {
                int val = doAlphaBetaPruning(alpha, beta, level+1, index*2+i);
                currBest = Math.max(val, currBest);
                alpha = Math.max(alpha, currBest);
                if (beta <= alpha) {
                    break;
                }
            }
            return currBest;
        } else {
            int currBest = INF;
            for (int i=0; i<=1; i++) {
                int val = doAlphaBetaPruning(alpha, beta, level+1, index*2+i);
                currBest = Math.min(val, currBest);
                beta = Math.min(beta, currBest);
                if (beta <= alpha) {
                    break;
                }
            }
            return currBest;
        }
    }

    public AlphaBetaPruning() {
        for (int i=0; i<8; i++) {
            value[i] = scan.nextInt();
        }
        scan.nextLine();

        System.out.println(doAlphaBetaPruning(-INF,INF,0,0));
    }
}
