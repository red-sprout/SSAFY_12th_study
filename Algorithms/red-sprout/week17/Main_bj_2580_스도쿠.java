import java.io.*;
import java.util.*;

public class Main_bj_2580_스도쿠 {
	static int[][] map;
	static List<int[]> list;
	static boolean isFinished;
	static void dfs(int depth) {
		if(isFinished) return;
		if(depth == list.size()) {
			isFinished = true;
			print();
			return;
		}
		int[] pos = list.get(depth);
		for(int val = 1; val <= 9; val++) {
			if(isValid(pos, val)) {
				map[pos[0]][pos[1]] = val;
				dfs(depth + 1);
				map[pos[0]][pos[1]] = 0;
			}
		}
	}
	static void print() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {				
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static boolean isValid(int[] pos, int val) {
		for(int r = 0; r < 9; r++) {
			if(r == pos[0]) continue;
			if(map[r][pos[1]] == val) return false;
		}
		for(int c = 0; c < 9; c++) {
			if(c == pos[1]) continue;
			if(map[pos[0]][c] == val) return false;
		}
		int row = 3 * (pos[0] / 3);
		int col = 3 * (pos[1] / 3);
		for(int r = 0; r < 3; r++) {
			for(int c = 0; c < 3; c++) {
				if(row + r == pos[0] && col + c == pos[1]) continue;
				if(map[row + r][col + c] == val) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[9][9];
		list = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) list.add(new int[] {i, j});
			}
		}
		isFinished = false;
		dfs(0);
		br.close();
	}
}
