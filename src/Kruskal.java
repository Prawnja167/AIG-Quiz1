import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Kruskal {
    int total_edge, src, dest, cost;
    int [] parent = new int[100];
    Vector<Edge> edges = new Vector<>();
    Scanner scan = new Scanner(System.in);

    int getGrandParent(int curr) {
        if (parent[curr] != curr) {
            parent[curr] = getGrandParent(parent[curr]);
        }
        return parent[curr];
    }

    public Kruskal() {
        total_edge = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < total_edge; i++) {
            parent[i] = i;
            src = scan.nextInt();
            dest = scan.nextInt();
            cost = scan.nextInt();
            scan.nextLine();
            edges.add(new Edge(src, dest, cost));
        }

        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge src1, Edge src2) {
                return src1.cost - src2.cost;
            }
        });

        int total = 0;

        for (Edge e : edges) {
            int source = e.src;
            int dest = e.desc;
            int cost = e.cost;

            if (getGrandParent(source) != getGrandParent(dest)) {
                total += cost;
                parent[getGrandParent(source)] = getGrandParent(dest);
            }
        }

        System.out.println(total);

    }

}
