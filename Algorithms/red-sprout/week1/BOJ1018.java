package week1;
// 체스판 다시 칠하기
import java.io.*;
import java.util.*;

public class BOJ1018 {
	private static final char[][] chessW =  {
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};
	private static final char[][] chessB = {
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/input_1018.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int answer = 64;
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				int tmp = 0;
				for(int r = 0; r < 8; r++) {
					for(int c = 0; c < 8; c++) {
						if(map[i + r][j + c] != chessW[r][c]) tmp++;
					}
				}
				answer = Math.min(answer, tmp);
				
				tmp = 0;
				for(int r = 0; r < 8; r++) {
					for(int c = 0; c < 8; c++) {
						if(map[i + r][j + c] != chessB[r][c]) tmp++;
					}
				}
				answer = Math.min(answer, tmp);
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
