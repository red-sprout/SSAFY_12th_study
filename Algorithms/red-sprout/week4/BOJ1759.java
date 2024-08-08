import java.io.*;
import java.util.*;

public class BOJ1759 {
	static int L, C;
	static char[] answer;
	static char[] words;
	static char[] moeum = {'a', 'e', 'i', 'o', 'u'};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = new char[L];
		
		st = new StringTokenizer(br.readLine());
		words = new char[C];
		for(int i = 0; i < C; i++) {
			words[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(words);
		dfs(0, 0);
		
		System.out.print(sb.toString());
		br.close();
	}
	
	public static void dfs(int idx, int now) {
		if(idx == L) {
			if(check()) add();
			return;
		}
		
		for(int i = now; i < C; i++) {
			answer[idx] = words[i];
			dfs(idx + 1, i + 1);
		}
	}
	
	public static boolean check() {
		int mo = 0;
		int ja = 0;
		for(char c : answer) {
			for(int i = 0; i < 5; i++) {
				if(moeum[i] == c) {
					mo++;
					break;
				}
				if(i == 4) ja++;
			}
		}
		
		return mo >= 1 && ja >= 2;
	}
	
	public static void add() {
		for(int i = 0; i < L; i++) {
			sb.append(answer[i]);
		}
		sb.append("\n");
	}
}
