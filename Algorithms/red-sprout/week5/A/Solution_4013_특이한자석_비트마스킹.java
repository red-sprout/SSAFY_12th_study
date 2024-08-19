import java.io.*;
import java.util.*;

class Solution_4013_특이한자석_비트마스킹 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");

            int K = Integer.parseInt(br.readLine()); // 횟수
            int[] gears = new int[4];

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 8; j++) {
                    int n = Integer.parseInt(st.nextToken());
                    gears[i] |= (n << j);
                }
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int rot = Integer.parseInt(st.nextToken());
                operation(idx, rot, gears);
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) answer |= ((gears[i] & 1) << i);
            sb.append(answer).append("\n");
        }

        System.out.print(sb.toString());
        br.close();
    }

    public static void operation(int idx, int rot, int[] gears) {
        int left = 0;
        int right = 0;
        for (int i = idx - 1; i >= 0; i--) {
            if ((gears[i + 1] & (1 << 6)) > 0 == (gears[i] & (1 << 2)) > 0) break;
            left++;
        }

        for (int i = idx + 1; i < 4; i++) {
            if ((gears[i - 1] & (1 << 2)) > 0 == (gears[i] & (1 << 6)) > 0) break;
            right++;
        }

        int initial = rot;
        rotation(idx, initial, gears);

        rot = -initial;
        for (int i = idx - 1; i >= idx - left; i--) {
            rotation(i, rot, gears);
            rot *= -1;
        }

        rot = -initial;
        for (int i = idx + 1; i <= idx + right; i++) {
            rotation(i, rot, gears);
            rot *= -1;
        }
    }

    public static void rotation(int idx, int mode, int[] gears) {
        if (mode == -1) {
            int bottom = (gears[idx] & 1);
            gears[idx] = gears[idx] >> 1;
            gears[idx] |= bottom << 7;
        } else {
            int top = (gears[idx] & (1 << 7)) > 0 ? 1 : 0;
            gears[idx] = gears[idx] << 1;
            gears[idx] |= top;
        }
    }
}