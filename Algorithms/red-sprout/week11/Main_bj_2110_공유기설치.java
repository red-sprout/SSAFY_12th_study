import java.io.*;
import java.util.*;

public class Main_bj_2110_공유기설치 {
	static int N, C, arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		System.out.println(solution());
		br.close();
	}
	
	private static int solution() {
		int left = 0;
		int right = arr[N - 1] - arr[0] + 1;
		while(left + 1 < right) {
			int mid = (left + right) / 2;
			if(count(mid)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return left;
	}

	private static boolean count(int l) {
		int result = 1;
		int dist = 0;
		for(int i = 1; i < N; i++) {
			dist += arr[i] - arr[i - 1];
			if(dist >= l) {
				result++;
				dist = 0;
			}
			if(result >= C) return true;
		}
		return result >= C;
	}
}
