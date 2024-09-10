import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251_Kruskal {
    // 1251. [S/W 문제해결 응용] 4일차 - 하나로
    static class Edge implements Comparable<Edge> {
        int A, B;
        double W;

        public Edge(int a, int b, double w) {
            A = a;
            B = b;
            W = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.W, o.W);
        }
    }

    static int T, N;
    static long[] X;
    static long[] Y;
    static double E;
    static Edge[] edges;
    static int[] p;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            X = new long[N];
            Y = new long[N];
            edges = new Edge[N * (N - 1) / 2];
            p = new int[N];

            // x
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Long.parseLong(st.nextToken());
            }

            // y
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                Y[i] = Long.parseLong(st.nextToken());
            }


            E = Double.parseDouble(br.readLine());

            makeSet();

            // 간선 만들기
            int edgeCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double distance = Math.sqrt(Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
                    double cost = E * Math.pow(distance, 2);
                    edges[edgeCount++] = new Edge(i, j, cost);
                }
            }

            // 정렬
            Arrays.sort(edges);

            // 크루스칼 알고리즘
            double result = 0;
            for (Edge edge : edges) {
                if (union(edge.A, edge.B)) {
                    result += edge.W;
                }
            }

            // 결과 출력
            System.out.printf("#%d %.0f\n", tc, result);
        }
    }

    private static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            p[rootB] = rootA;
            return true;
        }
        return false;
    }

    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void makeSet() {
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }
}