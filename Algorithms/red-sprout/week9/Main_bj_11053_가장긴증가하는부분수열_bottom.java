import java.io.*;
import java.util.*;

public class Main_bj_11053_가장긴증가하는부분수열_bottom {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp[i]);
		}
		
		System.out.println(answer);
		br.close();
	}
}
