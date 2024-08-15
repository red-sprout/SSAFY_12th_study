import java.io.*;
import java.util.*;

class Solution_4013_특이한자석_배열 {
    static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");

            int K = Integer.parseInt(br.readLine()); // 횟수
            gears = new int[4][8];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int rot = Integer.parseInt(st.nextToken());
                operation(idx, rot);
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) {
                answer |= (gears[i][0] << i);
            }
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    public static void operation(int idx, int rot) {
        int left = 0;
        int right = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if (gears[i + 1][6] == gears[i][2])
                break;
            left++;
        }

        for (int i = idx + 1; i < 4; i++) {
            if (gears[i - 1][2] == gears[i][6])
                break;
            right++;
        }

        int initial = rot;
        rotation(idx, initial);

        rot = -initial;
        for (int i = idx - 1; i >= idx - left; i--) {
            rotation(i, rot);
            rot *= -1;
        }

        rot = -initial;
        for (int i = idx + 1; i <= idx + right; i++) {
            rotation(i, rot);
            rot *= -1;
        }
    }

    public static void rotation(int idx, int mode) {
        int[] gear = gears[idx];
        if (mode == -1) {
            int bottom = gear[0];
            for (int i = 1; i < 8; i++) {
                gear[i - 1] = gear[i];
            }
            gear[7] = bottom;
        } else {
            int top = gear[7];
            for (int i = 6; i >= 0; i--) { // 방향 주의
                gear[i + 1] = gear[i];
            }
            gear[0] = top;
        }
    }
}