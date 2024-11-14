import java.io.*;
import java.util.*;

public class Main_bj_13023_ABCDE {
	static int N, M, answer;
	static boolean[] visited;
	static List<Integer>[] graph;
	static void dfs(int cur, int depth) {
		if(answer > 0) return;
		if(depth == 5) {
			answer = 1;
			return;
		}
		for(int next : graph[cur]) {
			if(visited[next]) continue;
			visited[next] = true;
			dfs(next, depth + 1);
			visited[next] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		visited = new boolean[N];
		graph = new List[N];
		for(int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i = 0; i < N; i++) {			
			dfs(i, 0);
		}
		System.out.println(answer);
		br.close();
	}
}
