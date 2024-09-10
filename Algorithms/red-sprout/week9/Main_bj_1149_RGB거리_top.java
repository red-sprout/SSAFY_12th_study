import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리_top {
	static int[][] cost, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		cost = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N + 1][3];
		System.out.println(Math.min(dfs(N, 0), Math.min(dfs(N, 1), dfs(N, 2))));
		br.close();
	}
	
	public static int dfs(int cur, int color) {
		if(dp[cur][color] != 0) return dp[cur][color];
		if(cur == 1) return dp[cur][color] = cost[cur][color];
		return dp[cur][color] = cost[cur][color] + Math.min(dfs(cur - 1, (color + 1) % 3), dfs(cur - 1, (color + 2) % 3));
	}
}
