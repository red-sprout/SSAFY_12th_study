import java.io.*;
import java.util.*;

public class BOJ2447 {
	private static int N;
	private static char[][] pattern;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pattern = new char[N][N];
		init();
		drawPattern(N, 0, 0);
		print();
		br.close();
	}
	
	public static void init() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				pattern[i][j] = ' ';
			}
		}
	}
	
	public static void drawPattern(int n, int r, int c) {
		if(n == 1) {
			pattern[r][c] = '*';
			return;
		}
		
		int dl = n / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) continue;
				int nr = r + dl * i;
				int nc = c + dl * j;
				drawPattern(dl, nr, nc);
			}
		}
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(pattern[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
