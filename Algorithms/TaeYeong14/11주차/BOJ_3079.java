import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 심사대 개수
        long M = Long.parseLong(st.nextToken());  // 심사를 받아야 하는 사람 수

        long[] times = new long[N]; // 각 심사대에서 심사하는데 걸리는 시간
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            if (times[i] > maxTime) {
                maxTime = times[i]; // 가장 긴 심사 시간을 저장
            }
        }

        // 이분 탐색 범위 설정
        long left = 0;
        long right = maxTime * M; // 최악의 경우: 가장 느린 심사관이 모든 사람을 심사할 때

        long result = right; // 최소 시간을 저장할 변수

        while (left <= right) {
            long mid = (left + right) / 2; // 중간 시간
            long total = 0;

            // mid 시간 동안 각 심사대에서 처리할 수 있는 사람의 수 계산
            for (int i = 0; i < N; i++) {
                total += mid / times[i];
                if (total >= M) break; // 이미 M명을 넘으면 더 계산할 필요 없음
            }

            if (total >= M) {
                result = mid; // 가능한 시간 중 최소를 찾음
                right = mid - 1; // 더 짧은 시간에서 시도
            } else {
                left = mid + 1; // 더 많은 시간이 필요함
            }
        }

        System.out.println(result); // 최소 시간 출력
    }
}
