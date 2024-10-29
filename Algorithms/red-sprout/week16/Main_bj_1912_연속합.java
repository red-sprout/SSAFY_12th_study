import java.io.*;
import java.util.*;

public class Main_bj_1912_연속합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
			ans = Math.max(ans, arr[i]);
		}
		System.out.println(ans);
		br.close();
	}
}
