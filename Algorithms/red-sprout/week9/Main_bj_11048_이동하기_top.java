import java.io.*;
import java.util.*;

public class Main_bj_11048_이동하기_top {
	static int N, M;
	static int[][] map, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(N - 1, M - 1));
		br.close();
	}
	
	public static int dfs(int r, int c) {
		if(r < 0 || r > N || c < 0 || c > M) return Integer.MIN_VALUE;
		if(dp[r][c] != -1) return dp[r][c];
		if(r == 0 && c == 0) return map[0][0];
		return dp[r][c] = map[r][c] + Math.max(dfs(r - 1, c - 1), Math.max(dfs(r - 1, c), dfs(r, c - 1)));
	}
}
