package week3;

import java.io.*;
import java.util.*;

public class BOJ_1074 {

	static int N, r, c; 
	static int count = 0; 

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		z((int)Math.pow(2, N), 0, 0); 
	}

	public static void z(int size, int x, int y) {
		if (x == r && y == c) {
			System.out.println(count); 
			return;
		}
		if (r < x + size && r >= x && c < y + size && c >= y) {
			int newSize = size / 2; 
			z(newSize, x, y); // 좌상
			z(newSize, x, y + newSize); // 우상
			z(newSize, x + newSize, y); // 좌하
			z(newSize, x + newSize, y + newSize); // 우하
		} else { 
			count += size * size;
		}
	}
}
