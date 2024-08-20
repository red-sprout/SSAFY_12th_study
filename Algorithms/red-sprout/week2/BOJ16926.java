import java.io.*;
import java.util.*;

public class BOJ16926 {
	private static int n, m, r;
	private static int[][] A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		A = new int[n][m];
		B = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		rotation();
		print(B);
		br.close();
	}
	
	public static void rotation() {
		int iter = Math.min(n, m) / 2;
		for(int i = 0; i < iter; i++) {
			int[][] arr = cand(i);
			int size = arr.length;
			int realR = r % size;
			
			for(int j = realR; j < size; j++) {
				int row = arr[j - realR][0];
				int col = arr[j - realR][1];
				B[row][col] = A[arr[j][0]][arr[j][1]];
			}
			
			for(int j = 0; j < realR; j++) {
				int row = arr[j - realR + size][0];
				int col = arr[j - realR + size][1];
				B[row][col] = A[arr[j][0]][arr[j][1]];
			}
		}
	}
	
	public static int[][] cand(int level) {
		int size = 2 * ((n - 2 * level - 1) + (m - 2 * level - 1));
		int[][] result = new int[size][2];
		
		int idx = 0;
		int now = level;
		
		// 0행 채우기
		for(int i = level; i < m - level - 1; i++) {
			result[idx][0] = level;
			result[idx][1] = i;
			idx++;
		}
		
		// m-1열 채우기
		for(int i = level; i < n - level - 1; i++) {
			result[idx][0] = i;
			result[idx][1] = m - level - 1;
			idx++;
		}

		// n-1행 채우기
		for(int i = m - level - 1; i > level ; i--) {
			result[idx][0] = n - level - 1;
			result[idx][1] = i;
			idx++;
		}
		
		// 0열 채우기
		for(int i = n - level - 1; i > level; i--) {
			result[idx][0] = i;
			result[idx][1] = level;
			idx++;
		}
		
		return result;
	}
	
	public static void print(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
