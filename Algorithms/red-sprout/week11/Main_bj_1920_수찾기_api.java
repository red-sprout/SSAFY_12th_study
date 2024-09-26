import java.io.*;
import java.util.*;

public class Main_bj_1920_수찾기_api {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			sb.append(Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0 ? 1 : 0).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
