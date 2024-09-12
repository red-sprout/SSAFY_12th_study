import java.io.*;
import java.util.*;
  
class Solution {
    static int N, W, H, answer;
    static int[][] map;
    static int[] order;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
           
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
               
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
               
            map = new int[H][W];
            order = new int[N];
               
            for(int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
               
            answer = W * H;
              
            perm(0);
            sb.append(answer).append("\n");
        }
           
        System.out.print(sb.toString());
        br.close();
    }
       
    public static void perm(int cnt) {
        if(cnt == N) {
            answer = Math.min(answer, countBricks());
            return;
        }
           
        int[][] backUp = new int[H][W];
        for(int i = 0; i < W; i++) {
            copyArr(map, backUp);
            explode(i);
            fall();
            perm(cnt + 1);
            copyArr(backUp, map);
        }
    }
       
    public static int countBricks() {
        int cnt = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                if(map[i][j] > 0) cnt++;
            }
        }
        return cnt;
    }
       
    public static void explode(int col) {
        int row;
        for(row = 0; row < H; row++) if(map[row][col] > 0) break;
        if(row == H) return;
           
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[H][W];
        q.offer(new int[] {row, col, map[row][col]});
        visited[row][col] = true;
           
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            int k = pos[2];
            map[r][c] = 0;
            for(int i = 1; i < k; i++) {             
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d] * i;
                    int nc = c + dc[d] * i;
                    if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if(map[nr][nc] > 0) {
                        q.offer(new int[] {nr, nc, map[nr][nc]});
                    }
                }
            }
        }
    }
       
    public static void fall() {
        for(int j = 0; j < W; j++) {
            int idx = H - 1;
            for(int i = H - 2; i >= 0; i--) {
                int now = map[i][j];
                int block = map[idx][j];
                if(now == 0) continue;
                map[i][j] = 0;
                if(block == 0) {
                    map[idx--][j] = now;
                } else {
                    map[--idx][j] = now;
                }
            }
        }
    }
       
    public static void copyArr(int[][] from, int[][] to) {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                to[i][j] = from[i][j];
            }
        }
    }
}
