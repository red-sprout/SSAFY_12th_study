package dp2;

import java.io.*;
import java.util.*;
public class BOJ_10844_ver2 {
	static int N, mod = 1000000000;
	static long dp[][], res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		dp = new long[N][10];
		// 1일때
		Arrays.fill(dp[0], 1);
		
		dp[0][0] = 0;

		dfs(1);
		
		System.out.println(res);
		
	}
	
	static void dfs(int cur) {
		if(cur == N) {
			for(int i=0; i<10; i++) {
				res= (res + dp[cur-1][i]) % mod;
			}
			return;
		}
		
		if(dp[cur][5] == 0) {
			dp[cur][0] = dp[cur-1][1] % mod;
			dp[cur][9] = dp[cur-1][8] % mod;
			for(int i=1;i<9;i++) {
				dp[cur][i] = (dp[cur-1][i-1] + dp[cur-1][i+1]) % mod;
			}
			
			dfs(cur+1);
		}
		
	}
}