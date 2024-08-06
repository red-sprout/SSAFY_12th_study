import java.io.*;
import java.util.*;

public class BOJ15649_basic {
	static int N, M;
	static int[] answer;
    static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];
        visited = new boolean[N + 1];
		sb = new StringBuilder();
		dfs(0);
		System.out.print(sb.toString());
		br.close();
	}
	public static void dfs(int idx) {
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			answer[idx] = i;
			dfs(idx + 1);
			visited[i] = false;
		}
	}
}
