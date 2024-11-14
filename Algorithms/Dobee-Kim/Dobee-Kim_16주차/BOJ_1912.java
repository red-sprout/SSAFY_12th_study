package oct_5th;

import java.io.*;
import java.util.*;

public class BOJ_1912 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] dp = new long[N];
		
		dp[0] = Integer.parseInt(st.nextToken());
		long prev = dp[0];
		for (int i=1; i<N; i++) {
			// 비교
			int next = Integer.parseInt(st.nextToken());
			dp[i] = next;
			dp[i] = Math.max(dp[i-1]+next, dp[i]);
			prev = Math.max(dp[i-1], prev);
		}
		
		System.out.println(Math.max(dp[N-1],prev));
	}
}
