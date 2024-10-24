import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());  // 전화번호 수
            String[] phoneNumbers = new String[n];

            for (int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine(); // 전화번호
            }

            // 전화번호 정렬
            Arrays.sort(phoneNumbers);

            // 실행
            boolean isStart = true;
            for (int j = 0; j < n - 1; j++) {
                // 다른 전화번호들이 가장 짧은 전화번호로 시작하는지 확인
                if (phoneNumbers[j + 1].startsWith(phoneNumbers[j])) {
                    isStart = false;
                    break;
                }
            }

            // 결과 출력
            if (isStart) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
