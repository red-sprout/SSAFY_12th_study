package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
// [백준] 12865. 평범한배낭
	
	static int N, W;
	static int[] weight;
	static int[] value;
	static int[] dp;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
     
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
  
       weight = new int[N + 1];
       value = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
       dp = new int[W + 1];

        //DP
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        
      
        System.out.println(dp[W]);
      
	}
	
}
