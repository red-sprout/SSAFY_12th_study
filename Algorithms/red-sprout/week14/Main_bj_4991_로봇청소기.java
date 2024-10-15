import java.io.*;
import java.util.*;

public class Main_bj_4991_로봇청소기 {
	static int w, h;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int r = 0, c = 0;
			if(w == 0 && h == 0) break;
			map = new char[h][w];
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				String row = br.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = row.charAt(j);
					switch(map[i][j]) {
					case 'o':
						r = i;
						c = j;
						map[i][j] = '.';
						break;
					case '*':
						map[i][j] = (char) ('0' + cnt++);
						break;
					}
				}
			}
			sb.append(bfs(r, c, cnt)).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
	private static int bfs(int r, int c, int cnt) {
		boolean[][][] v = new boolean[h][w][1 << cnt];
		Queue<int[]> q = new ArrayDeque<>();
		v[r][c][0] = true;
		q.offer(new int[] {r, c, 0, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int row = cur[0];
			int col = cur[1];
			int dist = cur[2];
			int visit = cur[3];
			if(visit == (1 << cnt) - 1) return dist;
			for(int d = 0; d < 4; d++) {
				int nr = row + dr[d];
				int nc = col + dc[d];
				if(nr < 0 || nr >= h || nc < 0 || nc >= w || v[nr][nc][visit]) continue;
				if(map[nr][nc] == '.') {
					v[nr][nc][visit] = true;
					q.offer(new int[] {nr, nc, dist + 1, visit});
				} else if(map[nr][nc] == 'x') {
					continue;
				} else {
					int idx = map[nr][nc] - '0';
					int nv = visit | (1 << idx);
					v[nr][nc][nv] = true;
					q.offer(new int[] {nr, nc, dist + 1, nv});
				}
			}
		}
		return -1;
	}
}
