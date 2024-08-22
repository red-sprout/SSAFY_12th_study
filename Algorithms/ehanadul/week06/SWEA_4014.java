package swea;

import java.util.*;
import java.io.*;

public class SWEA_4014 {
    // 4014. 활주로 건설

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            int[][] transposedMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    transposedMap[j][i] = map[i][j];
                }
            }

            int count = 0;

            // 활주로 가능한지 체크 -행
            count += countRunways(map, N, X);
            // 활주로 가능한지 체크 - 열
            count += countRunways(transposedMap, N, X);

            System.out.println("#" + tc + " " + count);
        }
    }

   

    // 활주로 가능 여부 체크
    private static int countRunways(int[][] map, int N, int X) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (isPossible(map, i, N, X)) {
                count++;
            }
        }
        return count;
    }

    // 활주로 가능 여부 검사
    private static boolean isPossible(int[][] map, int index, int N, int X) {
        int cnt = 1;
        boolean down = false;

        for (int j = 1; j < N; j++) {
            int currentHeight = map[index][j];
            int previousHeight = map[index][j - 1];

            if (previousHeight == currentHeight) {
                cnt++;
            } else if (previousHeight + 1 == currentHeight) { // 오르막
                if (!canPlaceSlope(down, cnt, X)) return false;
                down = false;
                cnt = 1;
            } else if (previousHeight - 1 == currentHeight) { // 내리막
                if (down && cnt < X) return false;
                down = true;
                cnt = 1;
            } else {
                return false; // 높이 차이가 1이 아니면 false
            }
        }

        return !down || (down && cnt >= X);
    }

    // 경사로 놓아도 되는지 확인
    private static boolean canPlaceSlope(boolean down, int cnt, int X) {
        return !(down && cnt < X) && !(cnt < X);
    }
}

