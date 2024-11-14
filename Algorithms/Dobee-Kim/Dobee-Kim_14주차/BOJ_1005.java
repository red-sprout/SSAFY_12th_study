package oct_3th;

import java.io.*;
import java.util.*;

// ACM Craft 80m
// 309852KB 	924ms
public class BOJ_1005 {
	static int T, N, K, cost[];
	static StringTokenizer st;
	static ArrayList<Integer>[] D;
	static int[] in;

	public static class Node {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		test: for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			// 건물 개수 N
			N = Integer.parseInt(st.nextToken());
			// 건설순서 규칙 K
			K = Integer.parseInt(st.nextToken());

			cost = new int[N + 1];
			D = new ArrayList[N + 1];
			
			for (int i=1; i<=N; i++) {
				D[i] = new ArrayList<>();
			}
			in = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				String[] st = br.readLine().split(" ");
				int from = Integer.parseInt(st[0]);
				int to = Integer.parseInt(st[1]);
				D[from].add(to);
				// 진입차수 계산
				in[to]++;
			}

			int end = Integer.parseInt(br.readLine());

			Queue<int[]> q = new ArrayDeque<>();
			int maxCost[] = new int[N + 1];

			// 진입차수가 0인 정점 찾기
			for (int i = 1; i <= N; i++) {
				if (in[i] == 0) {
					maxCost[i] = cost[i];
					q.offer(new int[] {i,0});
				}
			}


			while (!q.isEmpty()) {
				int[] now = q.poll();
				
				int nowIdx = now[0];
				int nowCost = now[1];


				// 건물 짓기 동시 진행 가능
				// 앞선 연결된 건물들이 다 건설 완료되어야만 그 다음 건물 건설 시작 가능
				for (int next : D[nowIdx]) {
					in[next]--;
					maxCost[next] = Math.max(maxCost[nowIdx] + cost[next], maxCost[next]);
					if (in[next]==0) {
						q.offer(new int[] {next, maxCost[nowIdx]});
					}
				}
			}

			System.out.println(maxCost[end]);

		}

		
		// 값 업데이트를 nowIdx 기준으로 했다가 답 틀림
		//	maxCost[nowIdx] = Math.max(maxCost[nowIdx], nowCost+cost[nowIdx]);
		// now기준으로 업데이트를 하면, 진입 차수가 2 이상일 때 문제가 생길 수 있음
		// maxCost의 초기값을 설정하지 않고 q에 추가한 이후, BFS 내부에서만 업데이트하는 방식은 진입 차수가 2 이상인 노드가 여러 개 있을 경우, 정확한 maxCost 값을 놓칠 수 있음.
		// 특정 노드가 여러 경로로 진입할 수 있는 경우, maxCost가 최대 비용으로 갱신되지 않을 가능성이 있음. 이는 진입 차수가 2 이상일 때, 한 번만 업데이트되면 더 이상 갱신되지 않기 때문.

	}
}
