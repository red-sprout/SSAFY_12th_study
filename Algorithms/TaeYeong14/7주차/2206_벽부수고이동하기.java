import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BoJ_2206_BreakTheWallAndMove {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int result;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }

        // [r][c][0] : 벽을 부수지 않은 경우, [r][c][1] : 벽을 부순 경우
        visited = new boolean[N][M][2];

        // 실행
        result = -1;

        bfs();

        // 결과 출력
        System.out.println(result);
    }
    
    static void bfs() {
        // 상하좌우
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, 1, 0 });  // (0, 0), 거리 1, 벽 부숨 여부 0 (안 부숨)
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            int wallBroken = cur[3];

            // 목적지에 도착한 경우
            if (r == N - 1 && c == M - 1) {
                result = dist;
                return;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 맵의 범위를 벗어나지 않는지 확인
                if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                    // 벽을 부수지 않고 이동하는 경우
                    if (map[nr][nc] == 0 && !visited[nr][nc][wallBroken]) {
                        visited[nr][nc][wallBroken] = true;
                        queue.add(new int[] { nr, nc, dist + 1, wallBroken });
                    }
                    // 벽을 부수고 이동하는 경우
                    if (map[nr][nc] == 1 && wallBroken == 0 && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true;
                        queue.add(new int[] { nr, nc, dist + 1, 1 });
                    }
                }
            }
        }

        // 목적지에 도달할 수 없는 경우
        result = -1;
    }
}
