import java.io.*;
import java.util.*;

public class SWEA_1251_Prim {
    // 1251. [S/W 문제해결 응용] 4일차 - 하나로
    // 프림 알고리즘으로 풉니다.

    static class Node {
        int idx;
        long x, y;

        Node(int idx, long x, long y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        Node n1, n2;
        long weight;

        Edge(Node n1, Node n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = calculateDistance(n1, n2);
        }

        @Override
        public int compareTo(Edge other) {
            return Long.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");

            int N = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[N];
            boolean[] visited = new boolean[N];

            long[] x = new long[N]; // x좌표
            long[] y = new long[N]; // y좌표
            long[] minCost = new long[N];
            Arrays.fill(minCost, Long.MAX_VALUE);

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) x[i] = Long.parseLong(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) y[i] = Long.parseLong(st.nextToken());

            for (int i = 0; i < N; i++) nodes[i] = new Node(i, x[i], y[i]);

            int count = 0;
            long totalCost = 0L;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            minCost[0] = 0;
            pq.offer(new Edge(nodes[0], nodes[0]));

            while (!pq.isEmpty()) {
                Edge currentEdge = pq.poll();
                Node minNode = currentEdge.n2;
                long minWeight = currentEdge.weight;

                if (visited[minNode.idx]) continue;
                visited[minNode.idx] = true;
                totalCost += minWeight;

                if (count++ == N - 1) break;

                for (int i = 0; i < N; i++) {
                    if (!visited[i] && minCost[i] > calculateDistance(minNode, nodes[i])) {
                        minCost[i] = calculateDistance(minNode, nodes[i]);
                        pq.offer(new Edge(minNode, nodes[i]));
                    }
                }
            }

            double E = Double.parseDouble(br.readLine());
            sb.append(Math.round(totalCost * E)).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    public static long calculateDistance(Node n1, Node n2) {
        return (n1.x - n2.x) * (n1.x - n2.x) + (n1.y - n2.y) * (n1.y - n2.y);
    }
}
