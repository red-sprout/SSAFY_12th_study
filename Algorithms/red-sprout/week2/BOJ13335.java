import java.io.*;
import java.util.*;

public class BOJ13335 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] truck = new int[n];
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < w; i++) {
			q.offer(0);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		int time = 0;
		int total = 0;
		while(true) {
			int out = q.poll();
			if(idx >= n && total == 0) break;
			
			total -= out;
			if(idx < n && total + truck[idx] <= L) {
				q.offer(truck[idx]);
				total += truck[idx++];
			} else {
				q.offer(0);
			}
			
			time++;
		}
		
		System.out.println(time);
		br.close();
	}
}
