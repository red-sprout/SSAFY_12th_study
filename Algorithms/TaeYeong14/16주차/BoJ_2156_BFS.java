import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] wine;
    static int n;
    static int maxSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        wine = new int[n];
        
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        dfs(0, 0, 0);
        System.out.println(maxSum);
    }
    
    static void dfs(int idx, int currentSum, int count) {
        if (idx >= n) {
            maxSum = Math.max(maxSum, currentSum);
            return;
        }
        
        // 현재 잔을 마시지 않고 다음 잔으로 이동
        dfs(idx + 1, currentSum, 0);

        // 현재 잔을 마시고, 연속된 3잔이 아닌 경우에만 합산
        if (count < 2) {
            dfs(idx + 1, currentSum + wine[idx], count + 1);
        }
    }
}
