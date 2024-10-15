import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BoJ_11779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 버스 개수

        // 그래프 초기화
        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
        }

        // 출발점, 도착점 입력
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        int[] minCost = new int[n + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;

        int[] prev = new int[n + 1];


        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int city = current.city;
            int cost = current.cost;

            if (cost > minCost[city])
                continue;

            for (Node next : graph[city]) {
                int newCost = cost + next.cost;
                if (newCost < minCost[next.city]) {
                    minCost[next.city] = newCost;
                    pq.add(new Node(next.city, newCost));
                    prev[next.city] = city; // 이전 도시 기록
                }
            }
        }


        // 경로 추적
        LinkedList<Integer> path = new LinkedList<>();
        int current = end;
        while (current != 0) {
            path.addFirst(current);
            current = prev[current];
        }

        // 결과 출력
        System.out.println(minCost[end]);

        System.out.println(path.size());

        for (int city : path) {
            System.out.print(city + " ");
        }
    }
    
    static class Node implements Comparable<Node> {
        int city;
        int cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
