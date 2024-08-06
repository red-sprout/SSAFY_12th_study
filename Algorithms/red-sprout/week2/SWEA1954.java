import java.util.Scanner;

class Solution {
  private static int[] dr = {0, 1, 0, -1};
  private static int[] dc = {1, 0, -1, 0};
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
    StringBuilder sb  = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append("\n");
      int N = sc.nextInt();
      int d = 0;
      int row = 0;
      int col = 0;
      int[][] arr = new int[N][N];
      for(int i = 1; i <= N * N; i++) {
          arr[row][col] = i;
          int nr = row + dr[d];
          int nc = col + dc[d];
          if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 0) {
              d = (d + 1) % 4;
          }
          nr = row + dr[d];
          nc = col + dc[d];
      row = nr;
          col = nc;
      }
      
      for(int i = 0; i < N; i++) {
        for(int j = 0; j < N; j++) {
              sb.append(arr[i][j]).append(" ");
          }
          sb.append("\n");
      }
		}
    System.out.print(sb);
    sc.close();
	}
}
