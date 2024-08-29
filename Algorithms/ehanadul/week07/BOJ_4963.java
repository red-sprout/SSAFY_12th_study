package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
	//4963. 섬의 개수
	static int[][] land;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int h;
    static int w;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            // 1 : 땅 , 0 : 바다
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break; //마지막 입력
                

            land = new int[h][w]; 
            visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < w; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && land[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (land[nx][ny] == 1 && !visited[nx][ny])
                dfs(nx, ny);
        }

    }
}