package dec_1st;

import java.io.*;
import java.util.*;

public class codetree_mazerunner {
	static int N, M, K, dist, exit[];
	static int[][] map;
	static StringTokenizer st;
	static Queue<int[]> participants;
	public static void main(String[] args) throws Exception{
		// 좌상단은 1-1
		// 출구를 향해 다가가야함
		// 움직이는 칸이 2개 이상이면 상하로 움직이는것을 우선
		// 벽은 회전할 때 내구도가 깎임
		// 참가자가 이동할 때 미로가 회전함
		// -> 한 명 이상의 참가자와 출구를 포함한 가장 작은 정사각형을 잡음
		// -> 가장 작은 정사각형이 2개 이상이면 -> r,c 순으로 작은 것
		// -> 선택된 정사각형은 시계방향으로 90도 회전, 회전된 벽은 내구도 -1
		// 게임 시작후 K초 / 모든 참가자의 미로 탈출시 이동거리 합과 출구 좌표
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = 0;
		
		map = new int[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		participants = new ArrayDeque<int[]>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());	
			participants.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		st = new StringTokenizer(br.readLine());	
		exit = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		
		
		// 큐에서 하나씩 체크하면서, 가로세로 거리 체크(더 가까운 방향으로 이동)
		move();

		
		// 이동후 회전
		
	}
	private static void move() {
		
		int[] ppl = participants.poll();
		
		int r  = Integer.compare(ppl[0], exit[0]);
		int c  = Integer.compare(ppl[1], exit[1]);
		if(Math.abs(r) < Math.abs(c)) {
			// r방향으로
			
		} else {
			// c방향으로
		
		}
		
		// 벽이 있으면 진행X 다시 큐에 넣기
		
		// 벽이 없으면 이동시키기 + 총 이동거리 증가
	}
}
