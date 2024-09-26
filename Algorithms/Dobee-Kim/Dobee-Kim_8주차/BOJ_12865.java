package dp1;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
	static int N, K, dp[][], bag[][], maxVal;
	static StringTokenizer st;
	
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);		
		K = Integer.parseInt(st[1]);
		
		maxVal = Integer.MIN_VALUE;
		bag = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0;i<N;i++) {
			st = br.readLine().split(" ");
			bag[i][0] =Integer.parseInt(st[0]); // W
			bag[i][1] =Integer.parseInt(st[1]); // V
		}
		
		dp(0,0);
		System.out.println(dp(0,0));
	}
	
	static int dp(int cnt, int weight) {
		if(weight>K) {
			return Integer.MIN_VALUE;
		}
		
		if(cnt==N) {
			return 0;
		}
		
		if(dp[cnt][weight]!= -1) return dp[cnt][weight];
		
		int a = dp(cnt+1, weight+bag[cnt][0]) + bag[cnt][1];		
		int b = dp(cnt+1, weight);
		
		return dp[cnt][weight] = Math.max(a, b);
	}
}
