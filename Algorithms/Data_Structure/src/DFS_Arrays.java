import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_Arrays {
		static int edge; // 간선의 수
		static int vertex; // 정점의 수
		static int[][] map; // 정점 간의 연결의 정보를 담는 객체
		static boolean[] visit; // 정점을 방문했는지 체크하기 위한 객체
		
		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
//			String array[] = s.split(" "); //공백마다 데이터 끊어서 배열에 넣음
			
			vertex = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
//			start = Integer.parseInt(st.nextToken());
			map = new int[vertex + 1][vertex + 1];
			visit = new boolean[vertex + 1];
			
			s = bf.readLine();
			st = StringTokenizer(bf);
			
			for (int i = 0; i < edge; i++) {
				int start = st.nextToken();
				int next = st.nextToken();
				
				map[start][next] = 1;
				map[next][start] = 1;
				
			}	
			dfs(1);
		}
		
		public static void dfs(int start) { //재귀호출 진행
			visit[start] = true;
			System.out.println(start + " ");
			
			for (int i=1; i < vertex +1 ; i++) {
				if (map[start][i]== 1 && visit[i]== false) {
					dfs(i);
				}
			}
		}
		
}
