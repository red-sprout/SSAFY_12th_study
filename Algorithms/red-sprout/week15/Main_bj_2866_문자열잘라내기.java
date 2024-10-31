import java.io.*;
import java.util.*;

public class Main_bj_2866_문자열잘라내기 {
	static int R, C;
	static char[][] table;
	static Set<String> set;
	static boolean isOverwrite(int start) {
		set.clear();
		for(int j = 0; j < C; j++) {
			StringBuilder sb = new StringBuilder();
			for(int i = start; i < R; i++) {
				sb.append(table[i][j]);
			}
			if(set.contains(sb.toString())) return true;
			set.add(sb.toString());
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		table = new char[R][C];
		set = new HashSet<>();
		for(int i = 0; i < R; i++) {
			table[i] = br.readLine().toCharArray();
		}
		int left = -1;
		int right = R;
		while(left + 1 < right) {
			int mid = (left + right) / 2;
			if(isOverwrite(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}
		System.out.println(left);
		br.close();
	}
}
