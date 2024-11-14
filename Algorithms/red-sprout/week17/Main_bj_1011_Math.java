import java.io.*;
import java.util.*;

public class Main_bj_1011_Math {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int answer = 0;
			int dist = y - x;
			int max = (int) Math.sqrt(dist);
			if(max == Math.sqrt(dist)) {
				answer = 2 * max - 1;
			} else if(dist <= max * max + max) {
				answer = 2 * max;
			} else {
				answer = 2 * max + 1;
			}
			sb.append(answer).append('\n');
		}
		System.out.print(sb.toString());
		br.close();
	}
}
