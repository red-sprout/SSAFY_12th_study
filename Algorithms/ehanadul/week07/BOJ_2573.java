package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static int N,M,yearCount,iceberg;
	static int[][] map;
	static int[][] newMap;
	static boolean[][] visited;
	static int[] dc = {-1, 1, 0, 0}; 
	static int[] dr = {0, 0, -1, 1};  
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i =0;i<N;i++) {
			st=new StringTokenizer(br.readLine().trim());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(map));
		yearCount=0;
		while(true) {
			iceberg=icebergCount();
			if(iceberg >=2) {
				System.out.println(yearCount);
				return;
			}
			
			if(meltIce()==0) {
				System.out.println(0);
				return;
			}
			
			yearCount++;
		}
	}

	private static int icebergCount() {
		visited = new boolean[N][M];
		int count =0;
		
		for(int i =0;i<N;i++) {
			for(int j =0; j<M; j++) {
				if(map[i][j] > 0 && !visited[i][j]) { 
					bfs(i,j,visited);// 연결된 빙산 탐색
					count++;
				}
			}
		}
		
		
		return count;
	}

	private static void bfs(int r, int c, boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{r,c});
		visited[r][c] = true; //방문처리
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			
			for(int d =0;d<4;d++) {
				int nr = current[0] + dr[d];
				int nc = current[1] + dc[d];
			
				if((r>=0 && c>=0 && r<N && c<M)&&
					!visited[nr][nc]&&
					map[nr][nc]>0) {
					
					visited[nr][nc] = true;
					queue.offer(new int[] {nr,nc}); // 큐 추가
				}
			
			
			}
		}
		
	}
	
	
	private static int meltIce() {
		int meltCount = 0;
		newMap = new int[N][M];//빙산 녹은 상태 저장할 배열
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>0) { //빙산이면
					int meltAmount = melt(i,j);//인접 바다 영역 계산(0)
					newMap[i][j] = Math.max(map[i][j]-meltAmount, 0);
					if (newMap[i][j] < map[i][j]) {
						meltCount++;
					}
				}
			}
		}
		map = newMap;
		return meltCount;
	}

	private static int melt(int r, int c) {//인접 바다 영역 계산(0)
		int meltAmount =0;
		for(int d =0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c+ dc[d];
			
			if((nr>=0 && nc>=0 && nr<N && nc<M) && map[nr][nc] ==0) {
				meltAmount++;
			}
		}
		return meltAmount;
	}
	
	
	
}
