import java.io.*;
import java.util.*;
  
class Solution {
    static class Node {
        int idx;
        long x, y;
        Node(int idx, long x, long y) {
            this.idx = idx;
            this.x = x; this.y = y;
        }
    }
      
    static class Edge implements Comparable<Edge> {
        Node n1, n2;
        long weight;
          
        Edge(Node n1, Node n2) {
            this.n1 = n1; this.n2 = n2;
            this.weight = getCost(n1, n2);
        }
          
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
          
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
              
            int N = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[N];
            boolean[] visited = new boolean[N];
              
            long[] xPos = new long[N];
            long[] yPos = new long[N];
            long[] cost = new long[N];
            Arrays.fill(cost, Long.MAX_VALUE);
              
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) xPos[i] = Long.parseLong(st.nextToken());
              
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) yPos[i] = Long.parseLong(st.nextToken());
              
            for(int i = 0; i < N; i++) nodes[i] = new Node(i, xPos[i], yPos[i]);
              
            int cnt = 0;
            long mst = 0l;
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            cost[0] = 0;
            pq.offer(new Edge(nodes[0], nodes[0]));
            while(!pq.isEmpty()) {
                Edge cur = pq.poll();
                Node minVertex = cur.n2;
                long min = cur.weight;
                if(visited[minVertex.idx]) continue;
                visited[minVertex.idx] = true;
                mst += min;
                if(cnt++ == N - 1) break;
                for(int i = 0; i < N; i++) {
                    if(!visited[i] && cost[i] > getCost(minVertex, nodes[i])) {
                        cost[i] = getCost(minVertex, nodes[i]);
                        pq.offer(new Edge(minVertex, nodes[i]));
                    }
                }
            }
              
            double E = Double.parseDouble(br.readLine());
            sb.append(Math.round(mst * E)).append("\n");
        }
          
        System.out.print(sb.toString());
        br.close();
    }
      
    public static long getCost(Node n1, Node n2) {
        return (n1.x - n2.x) * (n1.x - n2.x) + (n1.y - n2.y) * (n1.y - n2.y);
    }
}
