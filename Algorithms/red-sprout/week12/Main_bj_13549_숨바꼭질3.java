import java.io.*;
import java.util.*;

public class Main_bj_13549_숨바꼭질3 {
	static final int MAX = 200_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(N, K));
		br.close();
	}
	private static int dijkstra(int N, int K) {
		int[] time = new int[MAX];
		Arrays.fill(time, MAX);
		boolean[] visited = new boolean[MAX];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
		time[N] = 0;
		pq.offer(new int[] {N, time[N]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int x = cur[0];
			int t = cur[1];
			if(x == K) break;
			visited[x] = true;
			if(x - 1 >= 0 && !visited[x - 1] && time[x - 1] > t + 1) {
				time[x - 1] = t + 1;
				pq.offer(new int[] {x - 1, time[x - 1]});
			}
			if(x + 1 < MAX && !visited[x + 1] && time[x + 1] > t + 1) {
				time[x + 1] = t + 1;
				pq.offer(new int[] {x + 1, time[x + 1]});
			}
			if(2 * x < MAX && !visited[2 * x] && time[2 * x] > t) {
				time[2 * x] = t;
				pq.offer(new int[] {2 * x, time[2 * x]});
			}
		}
		return time[K];
	}
}
