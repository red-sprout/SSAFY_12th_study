package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long result = mul(a,b,c);
        System.out.println(result);
        
    
	}
	public static long mul(int a, int b, int c) {
        if (b == 0) 
        	return 1;
        long n = mul(a, b/2, c);
        if (b % 2 == 0)// b 짝수
            return n * n % c;
        else//b 홀수
            return (n * n % c) * a % c;
    }
	

}