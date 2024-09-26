import java.io.*;
import java.util.*;

public class Main_bj_11048_이동하기_bottom {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N][M];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dp[i][j] = map[i][j];
				if(i > 0) dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i - 1][j]);
				if(j > 0) dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i][j - 1]);
				if(i > 0 && j > 0) dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i - 1][j - 1]);
			}
		}
		
		System.out.println(dp[N - 1][M - 1]);
		br.close();
	}
}
