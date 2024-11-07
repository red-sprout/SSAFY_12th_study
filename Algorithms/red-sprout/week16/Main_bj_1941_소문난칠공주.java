import java.io.*;
import java.util.*;

public class Main_bj_1941_소문난칠공주 {
	static int ans;
	static char[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static void comb(int cnt, int start, int[] arr) {
		if(cnt == 7) {
			if(check(arr)) ans++;
			return;
		}
		for(int i = start; i < 25; i++) {
			arr[cnt] = i;
			comb(cnt + 1, i + 1, arr);
		}
	}
	static boolean check(int[] arr) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] valid = new boolean[5][5];
		for(int p : arr) {
			valid[p / 5][p % 5] = true;
		}
		q.offer(new int[] {arr[0] / 5, arr[0] % 5});
		valid[arr[0] / 5][arr[0] % 5] = false;
		int cnt = 0;
		int sCnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			int[] cur = q.poll();
			if(map[cur[0]][cur[1]] == 'S') sCnt++;
			for(int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || !valid[nr][nc]) continue;
				q.offer(new int[] {nr, nc});
				valid[nr][nc] = false;
			}
		}
		return cnt == 7 && sCnt >= 4;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		ans = 0;
		comb(0, 0, new int[7]);
		System.out.println(ans);
		br.close();
	}
}
