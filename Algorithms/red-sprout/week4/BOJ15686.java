import java.io.*;
import java.util.*;

public class BOJ15686 {
	static int N, M, result;
	static int[] selected;
	static List<int[]> clist;
	static List<int[]> hlist;
	static int[] dist;
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		selected = new int[M];
		clist = new ArrayList<>();
		hlist = new ArrayList<>();
		result = Integer.MAX_VALUE;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int info = Integer.parseInt(st.nextToken());
				switch(info) {
				case 1:
					hlist.add(new int[] {i, j});
					break;
				case 2:
					clist.add(new int[] {i, j});
					break;
				}
			}
		}
		
		dist = new int[hlist.size()];
		selection(0, 0);
		System.out.println(result);
		br.close();
	}
	
	public static void selection(int cnt, int idx) {
		if(cnt == M) {
			result = Math.min(result, findDistance());
			return;
		}
		
		for(int i = idx; i < clist.size(); i++) {
			selected[cnt] = i;
			selection(cnt + 1, i + 1);
		}
	}
	
	public static int findDistance() {
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int s : selected) {			
			for(int i = 0; i < dist.length; i++) {
				dist[i] = Math.min(dist[i], distance(clist.get(s), hlist.get(i)));
			}
		}
		
		int result = 0;
		for(int i : dist) result += i;
		return result;
	}
	
	public static int distance(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
}
