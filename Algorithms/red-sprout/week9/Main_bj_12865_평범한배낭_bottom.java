import java.io.*;
import java.util.*;

public class Main_bj_12865_평범한배낭_bottom {
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
		
		dp = new int[N + 1][K + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= K; j++) {
				if(i > 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
					if(j >= bag[i - 1][0]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - bag[i - 1][0]] + bag[i - 1][1]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		br.close();
	}
}
