import java.io.*;
import java.util.*;

public class Main_bj_4485_녹색옷입은애가젤다지 {
	static int N, map[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int prob = 1;
		while((N = Integer.parseInt(br.readLine())) != 0) {
			map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(prob++).append(": ").append(dijkstra()).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
	private static int dijkstra() {
		int[][] cost = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
		cost[0][0] = map[0][0];
		pq.offer(new int[] {0, 0, cost[0][0]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int r = cur[0];
			int c = cur[1];
			int t = cur[2];
			if(r == N - 1 && c == N - 1) break;
			visited[r][c] = true;
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(!visited[nr][nc] && cost[nr][nc] > t + map[nr][nc]) {
					cost[nr][nc] = t + map[nr][nc];
					pq.offer(new int[] {nr, nc, cost[nr][nc]});
				}
			}
		}
		return cost[N - 1][N - 1];
	}
}
