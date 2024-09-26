import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 개수

        int[] houses = new int[N];

        // 집 좌표 입력
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        // 집 좌표를 오름차순으로 정렬
        Arrays.sort(houses);

        // 이분 탐색 범위 설정
        int left = 1; // 최소 거리
        int right = houses[N - 1] - houses[0]; // 최대 거리
        int result = 0;

        // 이분 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 중간 거리
            int installed = houses[0]; // 첫 번째 집에 공유기 설치
            int count = 1; // 첫 번째 공유기 설치 완료

            // 다음 공유기를 설치할 수 있는지 확인
            for (int i = 1; i < N; i++) {
                if (houses[i] - installed >= mid) {
                    count++;
                    installed = houses[i]; // 공유기 설치
                }
            }

            if (count >= C) { // C개 이상의 공유기를 설치할 수 있다면
                result = mid; // 가능한 거리 중 가장 큰 값 저장
                left = mid + 1; // 더 큰 거리에서 탐색
            } else { // C개 미만의 공유기를 설치할 수 있다면
                right = mid - 1; // 거리를 줄여 탐색
            }
        }

        System.out.println(result); // 가장 인접한 두 공유기 사이의 최대 거리 출력
    }
}
