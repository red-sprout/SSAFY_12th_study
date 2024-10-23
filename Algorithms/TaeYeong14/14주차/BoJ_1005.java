import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 개수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 건물의 수
            int K = Integer.parseInt(st.nextToken());  // 규칙의 수

            int[] buildTime = new int[N + 1];  // 각 건물의 건설 시간 저장
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] adj = new ArrayList[N + 1];  // 건물 간의 의존 관계 저장
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            int[] inDegree = new int[N + 1];  // 진입 차수 저장 배열
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                adj[X].add(Y);  // X를 먼저 지은 후 Y를 지을 수 있다
                inDegree[Y]++;  // Y의 진입 차수 증가
            }

            int W = Integer.parseInt(br.readLine());  // 백준이가 지어야 하는 건물 번호

            // 위상 정렬 및 동적 프로그래밍
            Queue<Integer> queue = new ArrayDeque<>();
            int[] dp = new int[N + 1];  // 각 건물까지 걸리는 최소 시간을 저장할 배열

            // 진입 차수가 0인 건물들부터 큐에 추가
            for (int i = 1; i <= N; i++) {
                dp[i] = buildTime[i];  // 처음에는 각 건물의 건설 시간으로 초기화
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            // 위상 정렬을 이용한 처리
            while (!queue.isEmpty()) {
                int current = queue.poll();

                // 현재 건물에서 갈 수 있는 다음 건물들에 대해 처리
                for (int next : adj[current]) {
                    dp[next] = Math.max(dp[next], dp[current] + buildTime[next]);  // 더 오래 걸리는 시간을 선택
                    inDegree[next]--;

                    // 다음 건물의 진입 차수가 0이 되면 큐에 추가
                    if (inDegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            // 최종적으로 백준이가 지어야 하는 건물 W의 최소 시간을 출력
            System.out.println(dp[W]);
        }
    }
}
