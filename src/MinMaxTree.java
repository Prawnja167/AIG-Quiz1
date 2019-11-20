import java.util.Scanner;

public class MinMaxTree {
    final int INF = Integer.MAX_VALUE;
    int [] value = new int[50];
    Scanner scan = new Scanner(System.in);
    int max, min, currBest;

    public int getMinMax(int level, int index) {
        if(level == 3) {
            return value[index];
        } else if (level%2 == 0) {
            int currBest = -INF;
            for (int i=0; i<=1; i++) {
                int val = getMinMax(level+1, index*2+i);
                currBest = Math.max(val, currBest);
            }
            return currBest;
        } else {
            int currBest = INF;
            for (int i=0; i<=1; i++) {
                int val = getMinMax(level+1, index*2+i);
                currBest = Math.min(val, currBest);
            }
            return currBest;
        }
    }

    public MinMaxTree() {
        for (int i=0; i<8; i++) {
            value[i] = scan.nextInt();
        }
        scan.nextLine();

        System.out.println(getMinMax(0,0));
    }

}
