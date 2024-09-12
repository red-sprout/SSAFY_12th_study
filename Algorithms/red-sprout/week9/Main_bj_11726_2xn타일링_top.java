import java.io.*;
import java.util.*;

public class Main_bj_11726_2xn타일링_top {
	static int[] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(dfs(n));
		br.close();
	}
	
	public static int dfs(int cur) {
		if(dp[cur] != -1) return dp[cur];
		if(cur == 1) return 1;
		if(cur == 2) return 2;
		return dp[cur] = (dfs(cur - 1) + dfs(cur - 2)) % 10007;
	}
}
