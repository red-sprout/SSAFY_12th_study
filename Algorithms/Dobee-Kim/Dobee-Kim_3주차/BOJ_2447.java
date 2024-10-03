package BOJ;

import java.util.Scanner;

public class BOJ_2447 {
	static int N;
	static int[][] arr;
	static int[][] tmp;
	static int[][] pattern = {{0,0,0},{0,1,0},{0,0,0}};
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();

		arr = new int[N][N];
		make_star(N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (arr[i][j]==0) {
					sb.append("*");					
				}else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void make_star(int k) {
		if (k==1) {
			return ;
		} else {
			extend_pattern(k);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==0) { //비어있지 않은 경우에만 업데이트
						arr[i][j] = tmp[i%k][j%k];						
					}
				}
			}
			make_star(k/3);
		}
	}
	
	static void extend_pattern(int k) {
		tmp = new int[k][k];
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				tmp[i][j] = pattern[i/(k/3)][j/(k/3)];
//				sb.append(tmp[i][j]);
			}
//			sb.append("\n");
		}
//	System.out.println(sb.toString());
	}
	
}
