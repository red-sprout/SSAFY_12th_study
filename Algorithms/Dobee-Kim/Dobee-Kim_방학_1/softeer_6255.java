package dec_1st;

import java.io.*;
import java.util.*;


public class softeer_6255 {
	static int map[][];
	public static void main(String[] args) throws Exception{
		// 순차적으로 체크하되, 겹치면 넘기기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] line = br.readLine().toCharArray();
		
		int idx = -1;
		Set<Character> alphabet = new HashSet<Character>();
		for (char l : line) {
			if(!alphabet.contains(l)) {
				alphabet.add(l);
				idx++;
			}
			map[idx/5][idx%5] = l;
		}
		
		// 순차적으로 채우기
		
	}
}
