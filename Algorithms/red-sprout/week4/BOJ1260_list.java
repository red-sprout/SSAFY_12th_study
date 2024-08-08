import java.io.*;
import java.util.*;

public class BOJ1260 {
	static int N, M, V;
	static boolean[] visited;
	static List<Integer>[] graph;
	static StringBuilder dfsResult, bfsResult;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		graph = new List[N + 1]; // 인접 리스트
		dfsResult = new StringBuilder();
		bfsResult = new StringBuilder();
		
		for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) Collections.sort(graph[i]);
		dfs(V);
		
		Arrays.fill(visited, false);
		bfs(V);
		
		System.out.println(dfsResult);
		System.out.println(bfsResult);
		br.close();
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		dfsResult.append(node).append(" ");
		for(int next : graph[node]) {
			if(!visited[next]) dfs(next);
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[node] = true;
		q.offer(node);
		bfsResult.append(node).append(" ");
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
					bfsResult.append(next).append(" ");
				}
			}
		}
	}
}
