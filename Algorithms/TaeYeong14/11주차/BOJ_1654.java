import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] kNums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        kNums = new int[K];
        long maxnum = 0; // 가장 긴 막대의 길이로 설정
        long minnum = 1; // 최소 길이 1

        for (int i = 0; i < K; i++) {
            kNums[i] = Integer.parseInt(br.readLine());
            if (kNums[i] > maxnum) {
                maxnum = kNums[i]; // 최대 길이 설정
            }
        }

        long result = 0;

        // 이분 탐색 시작
        while (minnum <= maxnum) {
            long mid = (minnum + maxnum) / 2;
            int cnt = 0;

            // 각 막대를 mid 길이로 잘라서 몇 개가 나오는지 계산
            for (int i = 0; i < K; i++) {
                cnt += kNums[i] / mid;
            }

            if (cnt >= N) { // mid 길이로 N개 이상 만들 수 있는 경우
                result = mid; // 가능한 길이를 result에 저장
                minnum = mid + 1; // 더 긴 막대로 시도
            } else { // N개 미만인 경우
                maxnum = mid - 1; // 길이를 줄임
            }
        }

        System.out.println(result); // 결과 출력
    }
}
