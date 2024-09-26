package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {
    static StringTokenizer st;
    static int W, H, map[][], cnt;
    static boolean visited[][];
    static int[] dw = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dh = {1, 0, -1, 1, -1, 1, 0, -1};

public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
        st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        cnt = 0;
        if(W==0 && H ==0) break;
        
        map = new int[H][W];
        visited = new boolean[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        findIsland();
        
        System.out.println(cnt);
    }
}

private static void findIsland() {
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            if (map[i][j] == 1 && !visited[i][j]) {
            	visitLand(i, j);
                cnt++;
            }
        }
    }        
}

private static void visitLand(int h, int w) {
    visited[h][w] = true;
    
    for (int i = 0; i < dh.length; i++) {
        int nh = h + dh[i];
        int nw = w + dw[i];
        
        if (nh < 0 || nh >= H || nw < 0 || nw >= W || visited[nh][nw] || map[nh][nw] == 0) continue;
        visitLand(nh, nw); 
    }
}
}