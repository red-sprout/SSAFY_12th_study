import java.io.*;
import java.util.*;

public class Main_bj_11779_최소비용구하기2 {
	static int n;
	static List<int[]>[] graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		graph = new List[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
		}
		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;
		dijkstra(s, e);
		br.close();
	}
	private static void dijkstra(int s, int e) {
		int[] cost = new int[n];
		int[] before = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		Arrays.fill(before, -1);
		boolean[] visited = new boolean[n];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		cost[s] = 0;
		pq.add(new int[] {s, cost[s]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int c = cur[1];
			if(x == e) break;
			if(visited[x]) continue;
			visited[x] = true;
			for(int[] edge : graph[x]) {
				int nx = edge[0];
				int nc = edge[1]; 
				if(!visited[nx] && cost[nx] > c + nc) {
					cost[nx] = c + nc;
					before[nx] = x;
					pq.offer(new int[] {nx, cost[nx]});
				}
			}
		}
		System.out.println(cost[e]);
		Deque<Integer> deque = new ArrayDeque<>();
		deque.push(e);
		int cnt = 1;
		for(int i = 0; i < n; i++) {
			int idx = before[deque.peekLast()];
			if(idx == -1) break;
			deque.offer(idx);
			cnt++;
		}
		System.out.println(cnt);
		while(!deque.isEmpty()) {
			System.out.print(deque.pollLast() + 1 + " ");
		}
		System.out.println();
	}
}
