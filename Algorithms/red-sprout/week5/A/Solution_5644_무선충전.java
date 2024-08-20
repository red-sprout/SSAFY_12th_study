import java.io.*;
import java.util.*;

class Solution_5644_무선충전 {
    static int M, A;
    static int[] dr = { 0, -1, 0, 1, 0 };
    static int[] dc = { 0, 0, 1, 0, -1 };
    static int[][] movement;
    static int[][] BC;
    static List<Integer>[][] map; // 인덱스를 넣음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");

            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            movement = new int[M][2];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int i = 0; i < M; i++) {
                    movement[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BC = new int[A][4]; // 0 - x, 1 - y, 2 - 충전범위, 3 - 처리량
            map = new List[11][11];
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    map[i][j] = new ArrayList<>();
                }
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                BC[i][1] = Integer.parseInt(st.nextToken()); // col
                BC[i][0] = Integer.parseInt(st.nextToken()); // row
                BC[i][2] = Integer.parseInt(st.nextToken()); // C
                BC[i][3] = Integer.parseInt(st.nextToken()); // P
                map[BC[i][0]][BC[i][1]].add(i);
                bfs(i);
            }

            int[] a = { 1, 1 };
            int[] b = { 10, 10 };
            int answer = getMax(a, b);
            for (int i = 0; i < M; i++) {
                int ad = movement[i][0];
                int bd = movement[i][1];
                a[0] = a[0] + dr[ad];
                a[1] = a[1] + dc[ad];
                b[0] = b[0] + dr[bd];
                b[1] = b[1] + dc[bd];
                answer += getMax(a, b);
            }

            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    public static void bfs(int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[11][11];
        q.offer(new int[] { BC[idx][0], BC[idx][1], 0 });
        visited[BC[idx][0]][BC[idx][1]] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            int dist = pos[2];

            if (dist == BC[idx][2])
                return;

            for (int d = 1; d <= 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 1 || nr > 10 || nc < 1 || nc > 10)
                    continue;
                if (visited[nr][nc])
                    continue;

                map[nr][nc].add(idx);
                q.offer(new int[] { nr, nc, dist + 1 });
                visited[nr][nc] = true;
            }
        }
    }

    public static int getMax(int[] a, int[] b) {
        int[] result = { 0, 0 };
        if (map[a[0]][a[1]].isEmpty()) {
            for (int idx : map[b[0]][b[1]]) {
                result[1] = Math.max(result[1], BC[idx][3]);
            }
            return result[1];
        }

        if (map[b[0]][b[1]].isEmpty()) {
            for (int idx : map[a[0]][a[1]]) {
                result[0] = Math.max(result[0], BC[idx][3]);
            }
            return result[0];
        }

        for (int i : map[a[0]][a[1]]) {
            for (int j : map[b[0]][b[1]]) {
                int ap = BC[i][3];
                int bp = BC[j][3];
                if (i == j) {
                    ap /= 2;
                    bp /= 2;
                }
                if (result[0] + result[1] < ap + bp) {
                    result[0] = ap;
                    result[1] = bp;
                }
            }
        }

        return result[0] + result[1];
    }
}