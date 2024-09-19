package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053 {
// [백준] 11053. 가장 긴 증가하는 부분 수열
	
	static int N;
	static int[] A, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		Arrays.fill(dp, 1);
		
		for(int i =0; i<N; i++) {// 배열 전체
			for(int j=0; j<i; j++) {// 배열 인덱스 i의 앞부분
				if(A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] +1);
				}
			}
		}
		int result = 1;
		for(int i =0; i<N; i++) {
			result = Math.max(dp[i], result);
		}
		
		System.out.println(result);
	}
}


