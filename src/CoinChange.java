import java.util.Scanner;

public class CoinChange {
    int [] coins = new int[50];
    int num_coin, trade;
    Scanner scan = new Scanner(System.in);

    public int doCoinChange(int coins[], int num_coin, int trade) {
        if (trade == 0) {
            return 1;
        }
        if (trade < 0) {
            return 0;
        }
        if (num_coin<=0 && trade>=1) {
            return 0;
        }

        return doCoinChange(coins, num_coin-1, trade) + doCoinChange(coins, num_coin, trade-coins[num_coin-1]);
    }

    public CoinChange() {
        trade = scan.nextInt();
        num_coin = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<num_coin; i++) {
            coins[i] = scan.nextInt();
        }
        scan.nextLine();

        System.out.println(doCoinChange(coins, num_coin, trade));

    }
}
