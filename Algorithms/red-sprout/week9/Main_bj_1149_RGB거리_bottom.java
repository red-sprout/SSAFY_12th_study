import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리_bottom {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N + 1][3];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N + 1][3];
		for(int i = 0; i < 3; i++) dp[1][i] = cost[1][i];
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 3; j++) {				
				dp[i][j] = cost[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
			}
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		br.close();
	}
}
