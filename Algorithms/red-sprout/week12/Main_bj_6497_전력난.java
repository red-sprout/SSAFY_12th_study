import java.io.*;
import java.util.*;

public class Main_bj_6497_전력난 {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0) break;
			parent = new int[m];
			for(int i = 0; i < m; i++) {
				parent[i] = i;
			}
			int[][] edge = new int[2 * n][];
			int idx = 0;
			int total = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				edge[idx++] = new int[] {x, y, z};
				edge[idx++] = new int[] {y, x, z};			
				total += z;
			}
			int mst = 0;
			Arrays.sort(edge, (e1, e2) -> Integer.compare(e1[2], e2[2]));
			for(int[] e : edge) {
				if(update(e[0], e[1])) mst += e[2];
			}
			sb.append(total - mst).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
	private static int get(int x) {
		if(x == parent[x]) return x;
		return parent[x] = get(parent[x]);
	}
	private static boolean update(int x, int y) {
		x = get(x);
		y = get(y);
		if(x == y) return false;
		if(x > y) parent[x] = y;
		else parent[y] = x;
		return true;
	}
}
