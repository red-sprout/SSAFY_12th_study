import java.io.*;
import java.util.*;

public class Main_bj_1654_랜선자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution(K, N, arr));
		br.close();
	}

	private static long solution(int K, int N, int[] arr) {
		long left = 0;
		long right = (long)Integer.MAX_VALUE + 1;
		while(left + 1 < right) {
			long mid = (left + right) / 2;
			if(count(mid, arr) >= N) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private static long count(long mid, int[] arr) {
		long result = 0;
		for(int i = 0; i < arr.length; i++) {
			result += arr[i] / mid;
		}
		return result;
	}
}
