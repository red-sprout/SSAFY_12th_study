package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static int N, M, map[][];
	static StringTokenizer st;
	static boolean visited[][], divide;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		int sr = 0, sc = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int year = 0;
		
		while (!divide) {
			int landCnt=0;
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0 && !visited[i][j]) {
						bfs(i, j);
						landCnt++;
					}
				}
			}
//			System.out.println(landCnt);
//			print();
			if(landCnt > 1) {
				divide = true;
				break;
			}
			if(landCnt == 0) {
				year = 0;
				break;
			}
			year++;
		}
		System.out.println(year);
	}

	private static void bfs(int sr, int sc) {

		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int melt = 0;
			int[] rc = q.poll();
			int r = rc[0], c = rc[1];

			// 빙산 녹이기
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					melt++;
				}
				if (map[nr][nc] != 0 && !visited[nr][nc]) {
					q.offer(new int[] { nr, nc });
					visited[nr][nc] = true;
				}

			}
			map[r][c] -= melt;
			map[r][c] = map[r][c] < 0 ? 0 : map[r][c];
		}
	}
	
	static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("============");
	}

}
