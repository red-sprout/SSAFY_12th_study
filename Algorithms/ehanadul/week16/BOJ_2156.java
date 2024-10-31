package nana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
	
	static int N ;
	static Integer[] dp;
	static int[] drink;
	static long max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N+1];
		drink = new int[N+1];
		for(int i = 1 ; i < N+1 ; i++) {
			drink[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 0;
		dp[1] = drink[1];
		
		if(N > 1) {
			dp[2] = drink[1] + drink[2];
		}
		
		System.out.println(grape(N));
	}
	
	
	public static int grape(int d) {
			
		if(dp[d] == null)
			dp[d] = Math.max(Math.max(grape(d - 2), grape(d - 3) + drink[d - 1]) + drink[d], grape(d - 1));
			
		return dp[d];
	}
}
