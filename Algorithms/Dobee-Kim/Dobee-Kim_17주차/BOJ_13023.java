package nov_1th;
import java.io.*;
import java.util.*;
// 60m
public class BOJ_13023 {
	static StringTokenizer st;
	static int N, M;
	static ArrayList<Integer>[] adj;
	static boolean found = false;
	public static class Node implements Comparable<Node>{
		int idx;
		int depth;
		
		public Node(int idx, int depth) {
			this.idx = idx;
			this.depth = depth;
		}
		
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", depth=" + depth + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.depth, o.depth);
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		// 한붓그리기로 5개의 점 연속으로 잇기가 가능해야 함 (visited 배열 필요)
		// 진입차수가 0인점부터 시작해야지 최대점을 그릴 수 있음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N];
		
		for (int i=0; i<N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int[] inDegree = new int[N]; 
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
			inDegree[a] += 1;
			inDegree[b] += 1;
		}
		
		// 가장 끝단에서 시작하는 정점들 모으기 + DFS
		for (int i=0; i<N; i++) {
			if (inDegree[i]==1) {
				boolean visited[] = new boolean[N];
				visited[i] = true;
				connect(new Node(i,1), visited);
//				System.out.println(i);
				if (found) break;  // 하나라도 있으면 반복문 중지(전체 탐색할 필요x)
			}
		}
		
        System.out.println(found ? 1 : 0);
	}
	
	// DFS로 점 잇기, 연결이 5개 이상 있다면 끝
	public static void connect(Node now, boolean[] visited) {
		
//		System.out.println(Arrays.toString(visited));
		if (now.depth>=5) {
            found = true; // 연결을 찾았음을 표시하고 재귀 호출 중단
			return;
		}
		
		for (int i=0; i<adj[now.idx].size(); i++) {
			int next = adj[now.idx].get(i);
			
			if (visited[next]) continue;
			
			visited[next] = true;
			connect(new Node(next,now.depth+1), visited);
			visited[next] = false;
		}
		
		return;
	}
}
