package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
// [백준] 11726. 2×n 타일링
	
	static int N;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
		
		dp[0] = 1;
        if (N >= 1) {
            dp[1] = 1; 
        }
        
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; 
        }
        
        System.out.println(dp[N]);
		
	}
}
