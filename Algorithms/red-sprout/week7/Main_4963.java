import java.io.*;
import java.util.*;

public class Main_4963 {
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		String query = null;
		
		while((query = br.readLine()).charAt(0) != '0') {
			st = new StringTokenizer(query, " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		for(int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= h || nc < 0 || nc >= w || map[nr][nc] == 0 || visited[nr][nc]) continue;
			dfs(nr, nc);
		}
	}
}
