import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()); // 현재 위치 x
            long y = Long.parseLong(st.nextToken()); // 목표 위치 y
            sb.append(minMoves(x, y)).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int minMoves(long x, long y) {
        long distance = y - x; // 목표 위치 y와 현재 위치 x의 차이
        long maxMove = (long) Math.sqrt(distance); // 이동 거리가 distance에 가장 가깝게 도달할 수 있는 최대 움직임

        if (maxMove * maxMove == distance) {
            return (int) (2 * maxMove - 1); // 2 * maxMove - 1번 이동이 필요
        } else if (distance <= maxMove * maxMove + maxMove) {
            return (int) (2 * maxMove); // 2 * maxMove번 이동이 필요
        } else {
            return (int) (2 * maxMove + 1); // 2 * maxMove + 1번 이동이 필요
        }
    }
}
