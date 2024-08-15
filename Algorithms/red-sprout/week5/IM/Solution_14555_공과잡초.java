package week5;

import java.io.*;

class Solution_14555_공과잡초 {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input14555.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			String ground = br.readLine();
			int answer = 0;
			for(int i = 0; i < ground.length(); i++) {
				if(ground.charAt(i) == '(') {
					answer++;
					continue;
				}
				if(i != 0 && ground.charAt(i) == ')' && ground.charAt(i - 1) != '(') {
					answer++;
					continue;
				}
			}
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
