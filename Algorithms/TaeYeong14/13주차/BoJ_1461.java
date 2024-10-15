import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 책 개수
        int M = Integer.parseInt(st.nextToken()); // 한 번에 들 수 있는 책 개수

        st = new StringTokenizer(br.readLine());
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int position = Integer.parseInt(st.nextToken());
            if (position < 0) {
                negative.add(position);
            } else {
                positive.add(position);
            }
        }

        Collections.sort(negative);
        Collections.sort(positive, Collections.reverseOrder());

        int steps = 0; // 걸음 수
        int maxDistance = 0; // 가장 먼 거리

        for (int i = 0; i < negative.size(); i += M) {
            int distance = Math.abs(negative.get(i));
            steps += distance * 2;
            maxDistance = Math.max(maxDistance, distance);
        }

        for (int i = 0; i < positive.size(); i += M) {
            int distance = positive.get(i);
            steps += distance * 2;
            maxDistance = Math.max(maxDistance, distance);
        }

        // 마지막 가장 멀리 간 곳은 왕복 x
        steps -= maxDistance;

        System.out.println(steps);
    }
}
