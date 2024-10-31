package oct_5th;

import java.io.*;

// 13424KB	96ms
// 79m : dp할 때, 1일때, 2일때 다 고려할 것. 안되면 다 찍어보기

public class BOJ_2156 {
	public static void main(String[] args) throws Exception {
		// 포도주 잔 선택하면 모두 마심 -> 원위치
		// 연속 3잔 불가 (2잔까지 가능)
		// 가장 많은 양의 포도주

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N][3];

		// 0 0번 연속
		// 1 1번 연속
		// 2 2번 연속
		int first = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(first);
		} else if (N == 2) {
			int second = Integer.parseInt(br.readLine());
			System.out.println(first + second);
		} else {
			dp[0][0] = 0;
			dp[0][1] = first;
			dp[0][2] = first;

			int second = Integer.parseInt(br.readLine());
			dp[1][0] = first;
			dp[1][1] = second;
			dp[1][2] = first + second;

			for (int i = 2; i < N; i++) {
				int drink = Integer.parseInt(br.readLine());
				dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][0]);
				dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][2]) + drink; // 0이 연속으로 나오는 경우도 고려해야함
				dp[i][2] = Math.max(dp[i - 1][1], dp[i - 2][2]) + drink;
			}

//			for (int i = 0; i < dp.length; i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}

			long res = Math.max(dp[N - 1][0], dp[N - 1][1]);
			res = Math.max(dp[N - 1][2], res);

			System.out.println(res);
		}
	}
}
