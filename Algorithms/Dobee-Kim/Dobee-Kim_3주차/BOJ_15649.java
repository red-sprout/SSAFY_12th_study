package BOJ;

import java.util.Scanner;

public class BOJ_15649 {
	static int N, M;
	static boolean[] isSelected;
	static int[] arr;
	static int[] rst;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
				
		N = sc.nextInt();
		M = sc.nextInt();
		
		isSelected = new boolean[N];
		arr = new int[N];
		rst = new int[M];
		for (int i = 1; i<N+1; i++) {
			arr[i-1] = i;
		}
		
		make_perm(0);
		
		System.out.println(sb.toString());
		
	}
	
	private static void make_perm(int cnt) {
		if(cnt == M) {
			for (int i=0; i<rst.length; i++) {
				sb.append(rst[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i<N; i++) {
			if(isSelected[i]) continue;
			
			rst[cnt] = arr[i];
			isSelected[i] = true;
			
			make_perm(cnt+1);
			isSelected[i] = false;
		}
		
		
	};
}