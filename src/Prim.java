import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {
    int vertex,edge,src,dest,cost;
    int [][] edges = new int [50][50];
    boolean [] isVisit = new boolean[50];
    Scanner scan = new Scanner(System.in);

    public Prim() {
        for (int[] row : edges) {
            Arrays.fill(row, -1);
        }
        Arrays.fill(isVisit, false);

        vertex = scan.nextInt();
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

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        int total = 0;

        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            int source = pq.peek().index;
            int cost = pq.peek().cost;
            pq.poll();

            if (isVisit[source]) {
                continue;
            }
            isVisit[source] = true;

            total += cost;

            for (int i=0; i<vertex; i++) {
                if (edges[source][i] != -1) {
                    pq.add(new Node(i, edges[source][i]));
                }
            }

        }

        System.out.println(total);

    }
}
