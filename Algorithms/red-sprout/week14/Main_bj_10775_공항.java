import java.io.*;

public class Main_bj_10775_공항 {
	static int G, P;
	static int[] parent;
	static int get(int x) {
		if(parent[x] == x) return x;
		return parent[x] = get(parent[x]);
	}
	static boolean update(int x) {
		x = get(x);
		if(x == 0) return false;
		parent[x] = x - 1;
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		parent = new int[G + 1];
		for(int i = 1; i <= G; i++) {
			parent[i] = i;
		}
		int[] g = new int[P];
		for(int i = 0; i < P; i++) {
			g[i] = Integer.parseInt(br.readLine());
		}
		int idx = 0;
		for(idx = 0; idx < P; idx++) {
			if(!update(g[idx])) break;
		}
		System.out.println(idx);
		br.close();
	}
}
