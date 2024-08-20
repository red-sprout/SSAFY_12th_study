package week5;

import java.io.*;
import java.util.*;

class Solution_1959_두개의숫자열 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input1959.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());
			
			int answer = Integer.MIN_VALUE;
			if(N > M) {
				for(int k = 0; k <= N - M; k++) {
					int sum = 0;
					for(int i = 0; i < M; i++) {
						sum += A[k + i] * B[i];
					}
					answer = Math.max(answer, sum);
				}
			} else {
				for(int k = 0; k <= M - N; k++) {
					int sum = 0;
					for(int i = 0; i < N; i++) {
						sum += A[i] * B[k + i];
					}
					answer = Math.max(answer, sum);
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
