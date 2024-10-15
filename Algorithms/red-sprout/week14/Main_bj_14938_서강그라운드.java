import java.io.*;
import java.util.*;

public class Main_bj_14938_서강그라운드 {
	static final int MAX = 1_000_000_000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[] items = new int[n + 1];
		int[][] graph = new int[n + 1][n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= n; i++) {
			Arrays.fill(graph[i], MAX);
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph[a][b] = l;
			graph[b][a] = l;
		}
		for(int k = 1; k <= n; k++) {			
			for(int i = 1; i <= n; i++) {				
				for(int j = 1; j <= n; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			int sum = items[i];
			for(int j = 1; j <= n; j++) {
				if(i == j || graph[i][j] > m) continue;
				sum += items[j];
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
		br.close();
	}
}
