package dp1;
import java.io.*;
import java.util.*;
/*
73480KB	344ms
25m
 */
public class BOJ_11048 {
	static int map[], N, M;
	static int[] dr = {1,0,1};
	static int[] dc = {0,1,0};
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());		
		
		map = new int[M];
		Arrays.fill(map, 0);
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {				
				if(j-1 < 0) {
					map[j] = map[j] +Integer.parseInt(st.nextToken());
				}
				else {
					map[j] = Math.max(map[j], map[j-1]) + Integer.parseInt(st.nextToken());
				}
			}
		}
		
		System.out.println(map[M-1]);
	}
}
