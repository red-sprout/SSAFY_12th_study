import java.io.*;
import java.util.*;

public class Main_bj_15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] consults = new int[n + 2][2];
        int[] dp = new int[n + 2];
        int max = 0;

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            consults[i][0] = Integer.parseInt(st.nextToken());
            consults[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int day = 0;
        for(int i = 1; i <= n + 1; i++) {
        	max = Math.max(max, dp[i]);
        	day = i + consults[i][0];
        	
        	if(day > n + 1) continue;
        	
        	dp[day] = Math.max(dp[day], max + consults[i][1]);
        }

        System.out.println(max);
        br.close();
    }
}
