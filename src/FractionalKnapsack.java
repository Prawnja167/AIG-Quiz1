import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class FractionalKnapsack {
    int n, val, weight;
    String name;
    Vector<Item> items = new Vector<>();
    Scanner scan = new Scanner(System.in);

    public int doFractionalKnapsack(int knapsack) {
        int totalValue = 0;

        while (knapsack>0) {
            if (items.get(0).getWeight() == 0) {
                items.remove(0);
            }

            knapsack -= 1;
            totalValue += items.get(0).getTotalPerValue();
            items.get(0).setWeight(items.get(0).getWeight()-1);
        }

        return totalValue;
    }

    public FractionalKnapsack() {
        n = scan.nextInt();
        scan.nextLine();

        for (int i=0; i<n; i++) {
            name = scan.nextLine();
            val= scan.nextInt();
            weight = scan.nextInt();
            scan.nextLine();
            items.add(new Item(name, val, weight));
        }

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o2.totalPerValue - o1.totalPerValue;
            }
        });

        System.out.println(doFractionalKnapsack(50));

    }
}
