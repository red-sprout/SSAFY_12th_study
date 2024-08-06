package week1;
// 영화감독 숌
import java.io.*;
import java.util.*;

public class BOJ1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX = 666_0000;
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i <= MAX; i++) {
			String str = String.valueOf(i);
			if(str.contains("666")) N--;
			if(N == 0) {
				System.out.println(i);
				break;
			}
		}
		br.close();
	}
}
