package nana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
	static int N;
	static int[][] meeting;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	N =Integer.parseInt(br.readLine());
	
	meeting= new int[N][2];
	
	for(int i=0; i<N;i++) {
		st = new StringTokenizer(br.readLine());
		meeting[i][0] = Integer.parseInt(st.nextToken());
		meeting[i][1] = Integer.parseInt(st.nextToken());
	}// 입력끝
	
	Arrays.sort(meeting,(o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
	
	int count = 0;
	int lastTime = 0;
	
	for(int[] meetings : meeting) {
		if (meetings[0] >= lastTime) { 
            count++; 
            lastTime = meetings[1]; 
        }
	}
	
	System.out.println(count);
	}
}
