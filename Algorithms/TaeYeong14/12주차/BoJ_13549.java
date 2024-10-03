import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (X == K) {
            System.out.println(0);
            return;
        }

        int max = 100000;
        int[] visited = new int[max + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(X, 0));
        visited[N] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int position = current.position;
            int time = current.time;

            if (position == K) {
                System.out.println(time);
                return;
            }

            // X-1
            if (position - 1 >= 0 && visited[position - 1] > time + 1) {
                visited[position - 1] = time + 1;
                pq.add(new Node(position - 1, time + 1));
            }

            // X+1
            if (position + 1 <= max && visited[position + 1] > time + 1) {
                visited[position + 1] = time + 1;
                pq.add(new Node(position + 1, time + 1));
            }

            // 순간이동
            if (position * 2 <= max && visited[position * 2] > time) {
                visited[position * 2] = time;
                pq.add(new Node(position * 2, time));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int position;
        int time;

        Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
