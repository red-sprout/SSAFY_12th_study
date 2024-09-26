package binarySearch;

import java.io.*;
import java.util.*;

public class BOJ_1920 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		outer:
		for (int i = 0; i < M; i++) {
			int start = 0;
			int end = N - 1;
			int res = Integer.parseInt(st.nextToken());
			for (int j=0; j<Math.sqrt(N)+1; j++) {
				int mid = (int) (start + end) / 2;
				
				if(res == arr.get(mid)) {
					sb.append(1).append("\n");
					continue outer;
				}
				
				if(res > arr.get(mid)) {
					start = mid+1;
				}
				
				if(res < arr.get(mid)) {
					end = mid;
				}
			}
		sb.append(0).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
