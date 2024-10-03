import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BoJ_4386 {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] stars = new double[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken()); // x 좌표
            stars[i][1] = Double.parseDouble(st.nextToken()); // y 좌표
        }

        // 각 별의 부모를 자기 자신으로 초기화
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = getDistance(stars[i][0], stars[i][1], stars[j][0], stars[j][1]);
                pq.add(new Edge(i, j, distance));
            }
        }

        double totalCost = 0; // 총 비용
        int cnt = 0; // 사용된 간선의 수

        while (cnt < n - 1) {
            Edge edge = pq.poll();
            if (find(edge.from) != find(edge.to)) { // 두 별이 연결되어 있지 않으면
                union(edge.from, edge.to); // 두 별을 연결
                totalCost += edge.cost; // 비용 추가
                cnt++;
            }
        }

        // 결과 출력 (소수점 둘째 자리까지)
        System.out.printf("%.2f\n", totalCost);
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    // 두 별 사이의 거리 계산
    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.cost, o.cost);
        }
    }
}
