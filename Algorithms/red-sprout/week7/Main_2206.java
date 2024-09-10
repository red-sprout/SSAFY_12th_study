import java.io.*;
import java.util.*;

public class Main_2206 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] wall = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String row = br.readLine();
			for(int j = 0; j < M; j++) {
				wall[i][j] = row.charAt(j) == '1';
			}
		}
		
		System.out.println(bfs(N, M, wall));
		br.close();
	}
	
	public static int bfs(int N, int M, boolean[][] wall) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][2];
		int[][] dist = new int[N][M];
		
		q.offer(new int[] {0, 0, 0});
		visited[0][0][0] = true; visited[0][0][1] = true;
		dist[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int r = pos[0];
			int c = pos[1];
			int u = pos[2];
			if(r == N - 1 && c == M - 1) return dist[r][c];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(wall[nr][nc] && u == 0) {
					q.offer(new int[] {nr, nc, u + 1});
					visited[nr][nc][u + 1] = true;
					dist[nr][nc] = dist[r][c] + 1;
				} else if(!wall[nr][nc] && !visited[nr][nc][u]) {
					q.offer(new int[] {nr, nc, u});						
					visited[nr][nc][u] = true;
					dist[nr][nc] = dist[r][c] + 1;
				}
			}
		}
		
		return -1;
	}
}
