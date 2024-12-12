import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] map;
	static int[] exit = new int[2];
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static class Person {
		int id, row, col, dist;
		boolean isExist;
		
		Person(int id, int row, int col) {
			this.id = id;
			this.row = row;
			this.col = col;
			this.dist = 0;
			this.isExist = true;
		}
		
		@Override
		public String toString() {
			return "Person(" + id + ")"
					+ " - row : " + row
					+ " , col : " + col
					+ " , dist : " + dist
					+ (isExist ? "" : " - OUT");
		}
	}
	static Person[] person;
	static void movePerson(Person p) {
		int dist = distance(p.row, p.col, exit[0], exit[1]);
		int d = -1;
		for(int i = 0; i < 4; i++) {
			int nr = p.row + dr[i];
			int nc = p.col + dc[i];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] > 0) continue;
			int ndist = distance(nr, nc, exit[0], exit[1]);
			if(dist > ndist) {
				d = i;
				break;
			}
		}
		if(d != -1) {
			p.row += dr[d];
			p.col += dc[d];
			p.dist += 1;
			if(map[p.row][p.col] == -1) p.isExist = false;
		}
	}
	static int distance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
	static void moveMaze() {
		int size = 1, row = 0, col = 0;
		outer : for(size = 1; size <= N; size++) {
			for(row = 0; row < N; row++) {
				for(col = 0; col < N; col++) {
					if(checkMaze(row, col, size)) break outer;
				}
			}
		}
		int[][] result = rotation(row, col, size);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = result[i][j];
			}
		}
	}
	static boolean checkMaze(int row, int col, int size) {
		if(exit[0] < row || exit[0] >= row + size || exit[1] < col || exit[1] >= col + size) return false;
		for(Person p : person) {
			if(!p.isExist) continue;
			if(row <= p.row && p.row < row + size && col <= p.col && p.col < col + size) return true;
		}
		return false;
	}
	static int[][] rotation(int row, int col, int size) {
		int[][] result = new int[N][N];
		int[][] origin = new int[size][size];
		int[][] part = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				origin[i][j] = map[row + i][col + j];
			}
		}
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				part[i][j] = origin[size - 1 - j][i];
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(row <= i && i < row + size && col <= j && j < col + size) {
					int val = part[i - row][j - col];
					switch(val) {
						case -1: exit[0] = i; exit[1] = j;
						case 0: result[i][j] = val; break;
						default: result[i][j] = val - 1;
					}
				} else {
					result[i][j] = map[i][j];
				}
			}
		}
		for(Person p : person) {
			if(!p.isExist) continue;
			if(row <= p.row && p.row < row + size && col <= p.col && p.col < col + size) {
				int nr = (p.col - col);
				int nc = size - 1 - (p.row - row);
				p.row = nr + row;
				p.col = nc + col;
			}
		}
		return result;
	}
	static boolean isAllEscaped() {
		for(Person p : person) {
			if(p.isExist) return false;
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		person = new Person[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			person[i] = new Person(i, row, col);
		}
		st = new StringTokenizer(br.readLine(), " ");
		exit[0] = Integer.parseInt(st.nextToken()) - 1;
		exit[1] = Integer.parseInt(st.nextToken()) - 1;
		map[exit[0]][exit[1]] = -1;
		for(int time = 0; time < K; time++) {
			for(Person p : person) {
				if(p.isExist) movePerson(p);
			}
			moveMaze();
			if(isAllEscaped()) break;
		}
		int answer = 0;
		for(Person p : person) {
			answer += p.dist;
		}
		System.out.println(answer);
		System.out.println((exit[0] + 1) + " " + (exit[1] + 1));
		br.close();
	}
}
