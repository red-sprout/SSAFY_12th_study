import java.io.*;
import java.util.*;

public class Main_1005_ACMCraft {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] D = new int[N + 1];
			int[] prev = new int[N + 1];
			List<Integer>[] graph = new List[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				D[i] = Integer.parseInt(st.nextToken());
				graph[i] = new ArrayList<>();
			}
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				prev[b]++;
			}
			int W = Integer.parseInt(br.readLine());
			int[] cost = new int[N + 1];
			Arrays.fill(cost, Integer.MAX_VALUE);
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			for(int i = 1; i <= N; i++) {
				if(prev[i] == 0) {
					cost[i] = D[i];
					pq.offer(new int[] {i, cost[i]});
				}
			}
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int v = cur[0];
				int d = cur[1];
				for(int nxt : graph[v]) {
					if(--prev[nxt] == 0 && cost[nxt] > d + D[nxt]) {
						cost[nxt] = d + D[nxt];
						pq.offer(new int[] {nxt, cost[nxt]});
					}
				}
			}
			sb.append(cost[W]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
