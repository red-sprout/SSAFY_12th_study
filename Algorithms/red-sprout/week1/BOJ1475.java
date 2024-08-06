// 방 번호
import java.io.*;
import java.util.*;

public class BOJ1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int ans = 0;
		str = str.replaceAll("[9]", "6");
		for(char c = '0'; c <= '8'; c++) {
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				if (c == str.charAt(i)) {
					cnt++;
				}
			}
			if(c == '6') {
				cnt = (cnt + 1) / 2;
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		br.close();
	}
}
