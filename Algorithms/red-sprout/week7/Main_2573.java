import java.io.*;
import java.util.*;

public class Main_2573 {
	static int N, M;
	static int[][] map, minus;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		minus = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while(true) {
			init();
			int cnt = countIceberg();
			if(cnt >= 2) break;
			if(cnt == 0) {
				year = 0;
				break;
			}
			meltIceberg();		
			year++;
		}
		
		System.out.println(year);
		br.close();
	}

	public static void init() {
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
			Arrays.fill(minus[i], 0);
		}
	}
	
	public static int countIceberg() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) continue;
			dfs(nr, nc);
		}
	}
	

	public static void meltIceberg() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) minus[i][j] = Math.min(getWater(i, j), map[i][j]);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) map[i][j] -= minus[i][j];
			}
		}
	}
	
	public static int getWater(int r, int c) {
		int result = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0) continue;
			result++;
		}
		return result;
	}
}
