package platinum_study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11726 {
	static long[] memo = new long[1001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Arrays.fill(memo, -1);
		memo[1] = 1;
		memo[2] = 2;
		System.out.println(dp(N));
		
	}

	private static long dp(int n) {
		if(memo[n]!= -1) return memo[n];
		
		return memo[n] = (dp(n-1) + dp(n-2)) % 10007 ;
		
	}
	
}
