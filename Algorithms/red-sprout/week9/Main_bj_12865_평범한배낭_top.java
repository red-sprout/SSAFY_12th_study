import java.io.*;
import java.util.*;

public class Main_bj_12865_평범한배낭_top {
	static int N, K;
	static int[][] bag, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bag = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][K + 1];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(dfs(0, 0));
		br.close();
	}
	
	private static int dfs(int cur, int w) {
		if(w > K) return Integer.MIN_VALUE;
		if(cur == N) return 0;
		if(dp[cur][w] != -1) return dp[cur][w];
		dp[cur][w] = 0;
		return dp[cur][w] = Math.max(dfs(cur + 1, w + bag[cur][0]) + bag[cur][1], dfs(cur + 1, w));
	}
}
