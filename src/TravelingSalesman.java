import java.util.Arrays;
import java.util.Scanner;

public class TravelingSalesman {
    int bitmask, city_count, edge, src, dest, cost, maxValue;
    int [][] edges = new int[50][50];
    int [][] memo = new int[50][50];
    final int INF = Integer.MAX_VALUE;
    Scanner scan = new Scanner(System.in);

    public int doTravel(int cityIdx, int bitmask) {
        if (memo[bitmask][cityIdx] != -1) {
            return memo[bitmask][cityIdx];
        }

        if (bitmask == maxValue && cityIdx != 0) {
            return INF;
        }
        if (bitmask == maxValue && cityIdx == 0) {
            return 0;
        }

        int currCity = 1;
        int currBest = INF;

        for (int i=0;i<city_count; i++) {
            if ((currCity & bitmask) == 0 && edges[cityIdx][i] != -1) {
                int val = doTravel(i, (currCity | bitmask));
                if (val != INF) {
                    val += edges[cityIdx][i];
                    currBest = Math.min(val, currBest);
                }
            }
            currCity = currCity << 1;
        }

        memo[bitmask][cityIdx] = currBest;
        return memo[bitmask][cityIdx];

    }

    public TravelingSalesman() {
        for (int[] row : edges) {
            Arrays.fill(row, -1);
        }
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        city_count = scan.nextInt();
        edge = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<edge; i++) {
            src = scan.nextInt();
            dest = scan.nextInt();
            cost = scan.nextInt();
            scan.nextLine();

            edges[src][dest] = cost;
            edges[dest][src] = cost;
        }

        maxValue = (1<<city_count) - 1;
        System.out.println(doTravel(0,0));

    }
}
