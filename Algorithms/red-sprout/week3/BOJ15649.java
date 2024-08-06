import java.io.*;
import java.util.*;

public class BOJ15649 {
	static int N, M;
	static int[] answer;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
		sb = new StringBuilder();
		dfs(0, 0);
		System.out.print(sb.toString());
		br.close();
	}
	public static void dfs(int idx, int visited) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if((visited & 1 << i) > 0) continue;
			visited |= 1 << i;
			answer[idx] = i;
			dfs(idx + 1, visited);
			visited ^= 1 << i;
		}
	}
}
