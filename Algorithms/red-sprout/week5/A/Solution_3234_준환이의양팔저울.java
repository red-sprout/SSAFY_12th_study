import java.io.*;
import java.util.*;
 
class Solution_3234_준환이의양팔저울 {
    static int N;
    static long answer;
    static int[] arr, temp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
 
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            temp = new int[N];
            visited = new boolean[N];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
             
            answer = 0;
            perm(0); 
            sb.append(answer).append("\n");
        }
 
        System.out.print(sb.toString());
        br.close();
    }
     
    public static void perm(int idx) {
        if(idx == N) {
            scale(0, 0, 0);
            return;
        }
         
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            temp[idx] = i;
            perm(idx + 1);
            visited[i] = false;
        }
    }
     
    public static void scale(int idx, int left, int right) {
        if(left < right) return;
        if(idx == N) {
            answer++;
            return;
        }
         
        scale(idx + 1, left + arr[temp[idx]], right);
        scale(idx + 1, left, right + arr[temp[idx]]);
    }
}