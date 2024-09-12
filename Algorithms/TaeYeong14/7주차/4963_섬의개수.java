import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
    private static final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            // 입력
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            
            if (w == 0 && h == 0) break;
            
            map = new int[h][w];
            visited = new boolean[h][w];
            
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 실행
            int islandCount = 0;
            
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        islandCount++;
                    }
                }
            }

            // 결과 출력
            System.out.println(islandCount);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
