import java.io.*;
import java.util.*;

public class BOJ1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		System.out.println(pow(A, B, C));
		br.close();
	}
	
	public static long pow(int A, int B, int C) {
		if(B == 1) return A % C;
		long part = pow(A, B / 2, C);
		if(B % 2 == 0) return part * part % C;
		return (part * part % C) * A % C;
	}
}
