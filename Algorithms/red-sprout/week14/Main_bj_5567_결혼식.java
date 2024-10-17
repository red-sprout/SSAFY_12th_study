import java.io.*;
import java.util.*;

public class Main_bj_5567_결혼식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] graph = new List[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);			
		}
		int answer = 0;
		boolean[] v = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		v[1] = true;
		q.offer(1);
		for(int i = 0; i < 2; i++) {
			int size = q.size();
			for(int j = 0; j < size; j++) {
				int cur = q.poll();
				for(int next : graph[cur]) {
					if(!v[next]) {
						answer++;
						v[next] = true;
						q.offer(next);
					}
				}
			}
		}
		System.out.println(answer);
		br.close();
	}
}
