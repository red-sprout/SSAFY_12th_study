import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int w, h;
    static char[][] room;
    static List<Point> dirtyPoints;
    static int[][] distances;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 방의 가로 크기
            h = Integer.parseInt(st.nextToken()); // 방의 세로 크기
            if (w == 0 && h == 0) break;

            room = new char[h][w];
            dirtyPoints = new ArrayList<>();
            Point robot = null;
            
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    room[i][j] = line.charAt(j);
                    if (room[i][j] == 'o') {
                        robot = new Point(j, i);  // 로봇 시작 위치
                    } else if (room[i][j] == '*') {
                        dirtyPoints.add(new Point(j, i));  // 더러운 칸 위치
                    }
                }
            }

            // 로봇과 모든 더러운 칸의 최단 거리 계산
            dirtyPoints.add(0, robot); // 0번 위치에 로봇 추가
            int dirtyCount = dirtyPoints.size(); // 더러운 위치 cnt
            distances = new int[dirtyCount][dirtyCount]; // 거리 배열
            boolean possible = true;

            for (int i = 0; i < dirtyCount; i++) {
                if (!bfs(dirtyPoints.get(i), i)) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println(-1);
                continue;
            }

            // 외판원 순회 문제 해결
            int[][] dp = new int[dirtyCount][(1 << dirtyCount)];
            for (int i = 0; i < dirtyCount; i++) {
                Arrays.fill(dp[i], -1);
            }

            int result = tsp(0, 1, dirtyCount, dp);
            System.out.println(result);
        }
    }

    // 외판원 순회 문제의 재귀 함수 (TSP)
    static int tsp(int pos, int mask, int dirtyCount, int[][] dp) {
        if (mask == (1 << dirtyCount) - 1) {
            return 0;  // 모든 더러운 칸을 방문했으면 끝
        }
        
        if (dp[pos][mask] != -1) {
            return dp[pos][mask];
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dirtyCount; i++) {
            if ((mask & (1 << i)) == 0 && distances[pos][i] != -1) {  // 아직 방문하지 않은 칸
                ans = Math.min(ans, tsp(i, mask | (1 << i), dirtyCount, dp) + distances[pos][i]);
            }
        }

        return dp[pos][mask] = ans;
    }

    // BFS로 각 더러운 칸과 로봇 위치 간의 거리를 계산
    static boolean bfs(Point start, int startIdx) {
        visited = new boolean[h][w];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[start.y][start.x] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < w && ny >= 0 && ny < h && !visited[ny][nx] && room[ny][nx] != 'x') {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[y][x] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        // 시작점에서 다른 더러운 칸들과의 거리를 구한다.
        for (int i = 0; i < dirtyPoints.size(); i++) {
            Point dirty = dirtyPoints.get(i);
            distances[startIdx][i] = dist[dirty.y][dirty.x];
            if (dist[dirty.y][dirty.x] == -1) {  // 방문할 수 없는 경우
                return false;
            }
        }
        return true;
    }
    
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
