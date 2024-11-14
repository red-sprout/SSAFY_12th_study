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
		// �Ѻױ׸���� 5���� �� �������� �ձⰡ �����ؾ� �� (visited �迭 �ʿ�)
		// ���������� 0�������� �����ؾ��� �ִ����� �׸� �� ����
		
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
		
		// ���� ���ܿ��� �����ϴ� ������ ������ + DFS
		for (int i=0; i<N; i++) {
			if (inDegree[i]==1) {
				boolean visited[] = new boolean[N];
				visited[i] = true;
				connect(new Node(i,1), visited);
//				System.out.println(i);
				if (found) break;  // �ϳ��� ������ �ݺ��� ����(��ü Ž���� �ʿ�x)
			}
		}
		
        System.out.println(found ? 1 : 0);
	}
	
	// DFS�� �� �ձ�, ������ 5�� �̻� �ִٸ� ��
	public static void connect(Node now, boolean[] visited) {
		
//		System.out.println(Arrays.toString(visited));
		if (now.depth>=5) {
            found = true; // ������ ã������ ǥ���ϰ� ��� ȣ�� �ߴ�
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
