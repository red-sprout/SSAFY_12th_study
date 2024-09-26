package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
// [백준] 1149. RGB거리
	
	static int N;
	static int[][] cost, dp;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {  
            	// 0:빨, 1:초, 2:파
            	cost[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
		
		
		int[][] dp = new int[N][3];
		
		dp[0][0] = cost[0][0]; // 첫 번째 집 - 빨
	    dp[0][1] = cost[0][1]; // 첫 번째 집 - 초
	    dp[0][2] = cost[0][2]; // 첫 번째 집 - 파
		
		
	    for (int i = 1; i < N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 빨
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 초
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 파
        }
		
	    
	    int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(result);
	}
}

