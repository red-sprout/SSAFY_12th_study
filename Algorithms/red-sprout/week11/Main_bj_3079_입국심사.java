import java.io.*;
import java.util.*;

public class Main_bj_3079_입국심사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solution(N, M, arr));
		br.close();
	}

	private static long solution(int N, int M, int[] arr) {
		long left = 0;
		long right = 0;
		for(int i = 0; i < N; i++) {
			right = Math.max(right, arr[i]);
		}
		right *= M;
		while(left + 1 < right) {
			long mid = left + (right - left) / 2;
			if(count(mid, arr, M)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		return right;
	}

	private static boolean count(long mid, int[] arr, int M) {
		long result = 0;
		for(int i = 0; i < arr.length; i++) {
			result += mid / arr[i];
			if(result >= M) return true;
		}
		return result >= M;
	}
}
