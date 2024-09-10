import java.io.*;
import java.util.*;
  
class Solution {
    static int N;
    static int[] parent;
      
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
            this.weight = (n1.x - n2.x) * (n1.x - n2.x) + (n1.y - n2.y) * (n1.y - n2.y);
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
              
            N = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[N];
              
            long[] xPos = new long[N];
            long[] yPos = new long[N];
              
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) xPos[i] = Long.parseLong(st.nextToken());
              
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) yPos[i] = Long.parseLong(st.nextToken());
              
            for(int i = 0; i < N; i++) nodes[i] = new Node(i, xPos[i], yPos[i]);
              
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for(int i = 0; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    pq.offer(new Edge(nodes[i], nodes[j]));
                }
            }
              
            make();
            int cnt = 0;
            long cost = 0l;
            while(!pq.isEmpty()) {
                Edge edge = pq.poll();
                if(union(edge.n1, edge.n2)) {
                    cost += edge.weight;
                    if(++cnt == N - 1) break;
                }
            }
              
            double E = Double.parseDouble(br.readLine());
            sb.append(Math.round(cost * E)).append("\n");
        }
          
        System.out.print(sb.toString());
        br.close();
    }
      
    public static void make() {
        parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = -1;
    }
      
    public static int find(int a) {
        if(parent[a] < 0) return a;
        return parent[a] = find(parent[a]);
    }
      
    public static boolean union(Node n1, Node n2) {
        int a = find(n1.idx);
        int b = find(n2.idx);
        if(a == b) return false;
          
        parent[a] += parent[b];
        parent[b] = a;
        return true;
    }
}
