import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BoJ_2573_iceberg {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int year;
    static int iceCnt;

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 실행
        year = 0;
        iceCnt = -1;

        getResult();

        // 결과 출력
        System.out.println(year);
    }

    static void getResult() {
        while (true) {
            // 빙산 덩어리 개수 확인
            iceCnt = countOfIceberg();

            // 빙산 덩어리 개수가 0이면 return
            if (iceCnt == 0) {
                year = 0;
                return;
            }

            // 빙산이 두 덩어리 이상이면 return
            if (iceCnt >= 2) {
                return;
            }

            // 빙산 녹이기
            melting();

            year++;
        }
    }

    static int countOfIceberg() {
        int cnt = 0;
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0 && !visited[r][c]) {
                    bfs(r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (map[nr][nc] != 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }

    static void melting() {
        int[][] newMap = new int[N][M]; // 새로운 맵 생성

        // 1. 빙산 탐색 - 탐색하다가 0이 아니면 빙산
        // 2. 바닷물에 따른 빙산 변형 - 4방 탐색 -> 0 개수 카운트 -> 0 개수만큼 빼줌
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] != 0) {
                    int count = 0;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                            count++;
                        }
                    }
                    newMap[r][c] = Math.max(map[r][c] - count, 0);  // 음수일 때에는 0으로
                }
            }
        }

        // 원본 맵에 결과 적용
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = newMap[r][c];
            }
        }
    }

}
