import java.io.*;

public class Main_bj_2156_포도주시식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i <= n; i++) {
			if(i == 1) {
				dp[i] = wine[i];
			} else if(i == 2) {
				dp[i] = dp[i - 1] + wine[i];
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i] + wine[i - 1]));
			}
		}
		System.out.println(dp[n]);
		br.close();
	}
}
