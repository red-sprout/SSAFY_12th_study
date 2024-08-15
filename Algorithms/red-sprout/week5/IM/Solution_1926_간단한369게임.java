package week5;

import java.io.*;

class Solution_1926_간단한369게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int num = 1; num <= T; num++) {
			String str = String.valueOf(num);
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if(c == '3' || c == '6' || c == '9') cnt++;
			}
			
			if(cnt == 0) {
				sb.append(str);
			} else {
				for(int i = 0; i < cnt; i++) sb.append('-');
			}
			
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
