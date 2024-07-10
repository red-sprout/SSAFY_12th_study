// 색종이
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		
		String[] info = null;
		for(int t = 0; t < n; t++) {
			info = br.readLine().split(" ");
			int x = Integer.parseInt(info[0]);
			int y = Integer.parseInt(info[1]);
			for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {					
					paper[x + i][y + j] = true;
				}
			}
		}
		
		int area = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				area += paper[i][j] ? 1 : 0;
			}
		}
		
		System.out.println(area);
		br.close();
	}
}