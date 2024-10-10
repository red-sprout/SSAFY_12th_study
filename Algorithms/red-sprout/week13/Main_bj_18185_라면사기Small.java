import java.io.*;
import java.util.*;

public class Main_bj_18185_라면사기Small {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 2];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			if(arr[i + 1] > arr[i + 2]) {
				cnt = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
				answer += 5 * cnt;
				arr[i] -= cnt; arr[i + 1] -= cnt;
				
				cnt = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				answer += 7 * cnt;
				arr[i] -= cnt; arr[i + 1] -= cnt; arr[i + 2] -= cnt;
			} else {
				cnt = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
				answer += 7 * cnt;
				arr[i] -= cnt; arr[i + 1] -= cnt; arr[i + 2] -= cnt;
				
				cnt = Math.min(arr[i], arr[i + 1]);
				answer += 5 * cnt;
				arr[i] -= cnt; arr[i + 1] -= cnt;
			}
			answer += 3 * arr[i];
			arr[i] = 0;
		}
		System.out.println(answer);
		br.close();
	}
}
