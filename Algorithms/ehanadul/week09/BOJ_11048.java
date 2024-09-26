package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
// [백준] 11048. 이동하기
	
	static int N, M;
	static int[][] maze, dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		dp = new int[N+1][M+1];
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=M;j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력 끝

		
		//dp
		for(int i = 1; i<=N; i++) {
			for(int j =1; j<=M;j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])+ maze[i][j];
			}
		}
		
		System.out.println(dp[N][M]);		
	}
}
