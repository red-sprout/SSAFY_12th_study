import java.io.*;
import java.util.*;

public class Main_bj_4386_별자리만들기 {
	static class Edge implements Comparable<Edge>{
		int idx;
		double dist;
		Edge(int idx, double dist) {
			this.idx = idx;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist) > 0 ? 1 : -1;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		double[][] star = new double[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		double square = 0.0;
		double[] cost = new double[n];
		Arrays.fill(cost, Double.MAX_VALUE);
		boolean[] visited = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		cost[0] = 0;
		pq.offer(new Edge(0, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			double x = star[cur.idx][0];
			double y = star[cur.idx][1];
			if(visited[cur.idx]) continue;
			visited[cur.idx] = true;
			square += cur.dist;
			for(int i = 0; i < n; i++) {
				double nx = star[i][0];
				double ny = star[i][1];
				double nd = Math.sqrt((nx - x) * (nx - x) + (ny - y) * (ny - y));
				if(!visited[i] && cost[i] > nd) {
					cost[i] = nd;
					pq.offer(new Edge(i, cost[i]));
				}
			}
		}
		System.out.println(square);
		br.close();
	}
}
