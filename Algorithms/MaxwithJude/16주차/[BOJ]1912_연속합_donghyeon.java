import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	static int n;
	static int arr[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int dp [] = new int[n+1];
        int inf = Integer.MIN_VALUE;
        Arrays.fill(dp, inf);
        for(int i = 0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < n; i++) {
        	int a = 0;
        	for(int j = i; j < n; j++) {
        		a += arr[j];
        		if(a > dp[i]) {
        			dp[i] = a; 
        		        	
        		}
        	}
        }
        Arrays.sort(dp);
        System.out.println(dp[n]);
        
	}
}
//답은 맞는데 시간초과 뜨는 코드

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 노드 수
        
        
        int dp [] = new int[n+1];
        int inf = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
        	int idx = Integer.parseInt(st.nextToken());
        	dp[i] = Math.max(dp[i-1] + idx, idx);
        }
        
        for(int i = 1; i <= n; i++) {
        	if(dp[i] > inf)
        		inf = dp[i];
        }
        
        System.out.println(inf);
        
	}
}

