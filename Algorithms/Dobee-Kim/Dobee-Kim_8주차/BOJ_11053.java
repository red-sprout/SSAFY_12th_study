package dp1;

import java.io.*;
import java.util.*;
/*
12852KB	88ms
28m
 */
public class BOJ_11053 {
	
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] map = new int[N];
		int[] dp = new int[N];
		int maxLen = 0;
		dp[0] = 1;
		for(int i=0; i<N;i++) {
			map[i] = Integer.parseInt(st.nextToken());
			int tmp = -1;
			for (int j = 0; j < i; j++) {
				if(map[i] > map[j]) {
					tmp = Math.max(dp[j],tmp);
				}
				// dp 개수 계산
				if(tmp==-1) {
					dp[i] = 1;
				} else {
					dp[i] = tmp + 1;
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}
		System.out.println(maxLen);
//		for (int i = 0; i < dp.length; i++) {
//			System.out.println(dp[i]);
//		}
	}
}
