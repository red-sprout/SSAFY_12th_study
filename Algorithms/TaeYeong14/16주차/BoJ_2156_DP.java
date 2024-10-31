import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }
        
        int[] dp = new int[n];
        dp[0] = wine[0]; // 첫 번째 잔만 마심
        dp[1] = wine[0] + wine[1]; // 첫 번째와 두 번째 잔을 마심
        
        if (n > 2) {
            dp[2] = Math.max(dp[1], Math.max(wine[0] + wine[2], wine[1] + wine[2])); // 세 잔 중 최대 선택
        }
        
        for (int i = 3; i < n; i++) {
            // dp[i-1]: 현재 잔을 마시지 않는 경우
            // dp[i-2] + wine[i]: 현재 잔을 마시고 이전 잔을 건너뛰는 경우
            // dp[i-3] + wine[i-1] + wine[i]: 현재 잔과 그 이전 잔을 마시고, 그 이전의 이전 잔을 건너뛰는 경우
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        
        System.out.println(dp[n - 1]); // 최대로 마실 수 있는 포도주 양
    }
}
