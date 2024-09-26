package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1260 {
	private static int N; //노드 개수
	private static LinkedList<Integer>[] adj; // 인접 리스트
	private static StringBuilder sb;
	
	public static void initializeGraph(int n) { // 인접리스트 생성
		N = n;
		adj = new LinkedList[n+1];
        for (int i = 1; i < adj.length; i++) {
        	adj[i] = new LinkedList<>();
        }
        sb = new StringBuilder();
	}
	
	// 노드 연결
	public static void addEdge(int start, int end) {
		adj[start].add(end);
		adj[end].add(start); // 양방향으로 간선 추가
	}
	
	static // DFS - 방문여부 행렬 생성
	void DFS(int n, int v) {
		boolean[] visited = new boolean[n+1];
		DFS_util(v, visited);
	}
	
	// DFS util - 재귀
	static void DFS_util(int v, boolean visited[]) {
		visited[v] = true; // 첫 방문
		sb.append(v+" ");
		 Collections.sort(adj[v]); // 정점 번호가 작은 것부터 방문하기 위해 정렬
		Iterator<Integer> I = adj[v].listIterator();
		while(I.hasNext()) {
			int next = I.next();
			if (!visited[next]) {
				DFS_util(next, visited);
			}
		}
	}

	
	// BFS
	static void BFS(int n, int v) {
		boolean[] visited = new boolean[n+1];
		
		// 큐 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[v] = true; // 첫 방문
		queue.add(v); // 요소를 큐에 추가
		
		while(queue.size() != 0) { //queue가 빌 때까지 반복
			v = queue.poll(); // 첫 요소 빼오기
			sb.append(v+" ");
			 Collections.sort(adj[v]); // 정점 번호가 작은 것부터 방문하기 위해 정렬
			Iterator<Integer> I = adj[v].listIterator();
			while(I.hasNext()) { 
				int next = I.next();
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next); //자식 노드 추가
				}
			}
		}
	}

	

	

	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		initializeGraph(n);
		
        // 인접 리스트 구현
		for (int i=0; i < m; i++){ //array 안에 리스트 요소 추가
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st1.nextToken());
			int end = Integer.parseInt(st1.nextToken());
			addEdge(start, end);
		}
		
		DFS(n, v);
		sb.append('\n');
		BFS(n, v);
		System.out.println(sb.toString());
		

	}

	
}