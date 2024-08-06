import java.io.*;
import java.util.*;

public class BOJ1074 {
	private static int N, r, c;
	private static int order;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		order = 0;
		getOrder(N, r, c);
		System.out.println(order);
		br.close();
	}
	
	public static void getOrder(int n, int r, int c) {
		if(n == 0) return;
		int dl = pow(n - 1);
		int da = dl * dl;
		
		if(r < dl && c < dl) {
			order += 0;
		} else if(r < dl && c >= dl) {
			order += da;
			c -= dl;
		} else if(r >= dl && c < dl) {
			order += 2 * da;
			r -= dl;
		} else if(r >= dl && c >= dl) {
			order += 3 * da;
			r -= dl;
			c -= dl;
		}
		
		getOrder(n - 1, r, c);
	}
	
	public static int pow(int n) {
		int result = 1;
		for(int i = 0; i < n; i++) result *= 2;
		return result;
	}
}
