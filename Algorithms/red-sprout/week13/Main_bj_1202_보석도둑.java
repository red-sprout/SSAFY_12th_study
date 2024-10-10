import java.io.*;
import java.util.*;

public class Main_bj_1202_보석도둑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] germs = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			germs[i][0] = Integer.parseInt(st.nextToken());
			germs[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] bags = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(germs, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long answer = 0;
		int gIdx = 0;
		for(int i = 0; i < K; i++) {
			while(gIdx < N) {
				if(bags[i] < germs[gIdx][0]) break;
				pq.offer(germs[gIdx++][1]);
			}
			if(!pq.isEmpty()) answer += pq.poll();
		}
		System.out.println(answer);
		br.close();
	}
}
