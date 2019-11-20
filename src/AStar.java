import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AStar {
    int node, edge, src, dest, cost, start, finish;
    int [] heuristic = new int[50];
    int [][] edges = new int[50][50];
    int [] shortestPath = new int[50];
    boolean [] isVisited = new boolean[50];
    int INF = Integer.MAX_VALUE;
    Scanner scan = new Scanner(System.in);

    public AStar() {
        for(int[] row : edges) {
            Arrays.fill(row, -1);
        }
        Arrays.fill(isVisited, false);
        Arrays.fill(shortestPath, INF);

        node = scan.nextInt();
        edge = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<node; i++) {
            heuristic[i] = scan.nextInt();
        }
        scan.nextLine();

        for(int i=0; i<edge; i++) {
            src = scan.nextInt();
            dest = scan.nextInt();
            cost = scan.nextInt();
            scan.nextLine();
            edges[src][dest] = cost;
            edges[dest][src] = cost;
        }

        start = scan.nextInt();
        finish = scan.nextInt();
        scan.nextLine();

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Node(start, 0));
        shortestPath[start] = 0;

        while(!pq.isEmpty()) {
            int source = pq.peek().index;
            int cost = pq.peek().cost;
            pq.poll();

            if (isVisited[source]) {
                continue;
            }
            isVisited[source] = true;

            if (source == finish) {
                break;
            }

            for (int i=0; i<node; i++) {
                if (edges[source][i] != -1 && (edges[source][i] + cost + heuristic[i] < shortestPath[i])) {
                    shortestPath[i] = edges[source][i] + cost + heuristic[i];
                    pq.add(new Node(i, shortestPath[i]));
                }
            }

        }

        System.out.println(shortestPath[finish]);
        for (int i=0; i<node; i++) {
            System.out.println(i+": "+shortestPath[i]);
        }

    }

}
