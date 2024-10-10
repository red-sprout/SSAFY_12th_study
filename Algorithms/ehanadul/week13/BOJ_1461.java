package nana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BOJ_1461 {
 //[백준] 1461. 도서관
	
	static int N,M;
	static int[] book;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		book = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			book[i] = Integer.parseInt(st.nextToken());
		}
		//입력 끝
		
		Arrays.sort(book);
		
		int totalDis = 0;
		int maxDis=0;
				
		
//		for(int i =N-1; i>=0; i-=M) {
//		totalDis += Math.abs(book[i])*2;//왕복
//		maxDis = Math.max(maxDis, Math.abs(book[i]));
//		}
		//음수
		for (int i = 0; i < N; i++) {
            if (book[i] < 0) {
                if ((i % M) == 0) {
                    totalDis += Math.abs(book[i]) * 2;
                }
                maxDis = Math.max(maxDis, Math.abs(book[i]));
            }
        }

        //양수
        for (int i = N - 1; i >= 0; i--) {
            if (book[i] > 0) {
                if (((N - 1 - i) % M) == 0) {
                    totalDis += book[i] * 2;
                }
                maxDis = Math.max(maxDis, book[i]);
            }
        }
		
		
		totalDis -= maxDis;
		
		System.out.println(totalDis);
		br.close();
	}
}