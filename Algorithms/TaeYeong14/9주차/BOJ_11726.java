import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		System.out.println(getResult(num));
	}

	public static int getResult(int n) {

		int[] dp = new int[n + 1];

		dp[1] = 1;

		if (n > 1) {
			dp[2] = 2;
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		return dp[n];
	}
}
