import java.io.*;

public class BOJ11729 {
	private static int cnt;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cnt = 0;
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(cnt);
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void hanoi(int n, int start, int empty, int end) {
		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			cnt++;
			return;
		}
		
		hanoi(n - 1, start, end, empty);
		hanoi(1, start, empty, end);
		hanoi(n - 1, empty, start, end);
	}
}
