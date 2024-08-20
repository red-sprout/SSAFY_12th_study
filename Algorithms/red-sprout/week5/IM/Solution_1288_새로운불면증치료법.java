package week5;

import java.io.*;

class Solution_1288_새로운불면증치료법 {
	static final int END = (1 << 10) - 1;
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/input1288.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			sb.append("#").append(test).append(" ");
			
			int checked = 0;
			long answer = 0;
			int N = Integer.parseInt(br.readLine());
			while(true) {
				answer += N;
				for(int i = 1; answer / i > 0 ; i *= 10) checked |= (1 << ((answer / i) % 10));
				if(checked == END) break;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.print(sb.toString());
		br.close();
	}
}
