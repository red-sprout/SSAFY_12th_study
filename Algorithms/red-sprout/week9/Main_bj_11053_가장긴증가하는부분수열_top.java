import java.io.*;
import java.util.*;

public class Main_bj_11053_가장긴증가하는부분수열_top {
	static int[] arr, dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		dfs(N - 1);
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
	
	public static int dfs(int cur) {
		if(dp[cur] != 0) return dp[cur];
		
		dp[cur] = 1;
		for(int i = 0; i < cur; i++) {
			if(arr[i] < arr[cur]) dp[cur] = Math.max(dp[cur], dfs(i) + 1);
			else dp[i] = dfs(i);
		}
		
		return dp[cur];
	}
}
