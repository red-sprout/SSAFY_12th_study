package dp1;

import java.io.*;
import java.util.*;
/*
12068KB	72ms
18m
 */
public class BOJ_1149 {
	static int dp[][], N;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N][3];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<3;j++) {
				if(i-1<0) dp[i][j] = Integer.parseInt(st.nextToken());
				else {
					switch (j) {
					case 0 :
						dp[i][j] = Math.min(dp[i-1][1],dp[i-1][2])+Integer.parseInt(st.nextToken());						
						break;
					case 1 :
						dp[i][j] = Math.min(dp[i-1][0],dp[i-1][2])+Integer.parseInt(st.nextToken());						
						break;
					case 2 :
						dp[i][j] = Math.min(dp[i-1][0],dp[i-1][1])+Integer.parseInt(st.nextToken());						
						break;
					}
				}
			}
		}
		
		int minVal = Math.min(dp[N-1][0],dp[N-1][1]);
		minVal = Math.min(dp[N-1][2], minVal);
		System.out.println(minVal);
	}

}
