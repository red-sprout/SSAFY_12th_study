import java.io.*;
import java.util.*;

public class BOJ15684 {
	static int N, M, H;
	static boolean isEnd; // 모든 작업이 끝났는지 확인하는 flag
	static boolean[][] ladder; // 사다리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ladder = new boolean[H + 1][N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ladder[a][b] = true;
		}
		// 사다리 출력
//		printLadder();
		
		isEnd = false;
		for(int test = 0; test <= 3; test++) {			
			dfs(1, 0, test);
			if(isEnd) break;
		}
		
		if(!isEnd) System.out.println(-1);
		br.close();
	}
	
	// 사다리 끝을 보는 메소드
	public static int getEnd(int row, int col) {
		if(row == H + 1) return col;
		if(col < N && ladder[row][col]) col++;
		else if(col > 1 && ladder[row][col - 1]) col--;
		
		return getEnd(row + 1, col);
	}	
	
	// 1 ~ N까지 돌려서 모두 확인해봅니다.
	public static boolean isSameEnd(boolean[][] ladder) {
		for(int i = 1; i <= N; i++) {
			if(i != getEnd(0, i)) return false;
		}
		return true;
	}
	
	// 백트래킹 로직
	// 불필요한 순서를 빼주기 위해서 현재 row 부터 놓는 방식 채택
	// 참고 백준 15650 https://www.acmicpc.net/problem/15650
	public static void dfs(int row, int cnt, int test) throws IOException {
		if(isEnd) return;
		if(cnt == test) {
			if(isSameEnd(ladder)) {			
				System.out.println(cnt);
				isEnd = true;
			}
			return;
		}

		for(int i = row; i <= H; i++) {
			for(int j = 1; j <= N; j++) {
				if(ladder[i][j]) continue; // 연결되어 있는 사다리는 구지 연결할 필요 없음
				if(j == 1 && ladder[i][j + 1]) continue; // (제일 왼쪽만 조건 따로) 연결 했을 때 사다리가 + 모양 되는 것 방지
				else if(j == N) continue; // 제일 오른쪽에서는 사다리 추가 오른쪽으로 안됨
				else if(ladder[i][j + 1] || ladder[i][j - 1]) continue; // 연결 했을 때 사다리가 + 모양 되는 것 방지
				ladder[i][j] = true;
				dfs(i, cnt + 1, test);
				ladder[i][j] = false;
			}
		}
	}
	
	// 사다리 출력
	public static void printLadder() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= N; j++) {
				sb.append("|");
				if(ladder[i][j]) {
					sb.append("-");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
