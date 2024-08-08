import java.io.*;

public class BOJ9663 {
    static int N;
    static int ans = 0;
    static int[] index;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        index = new int[N];
        visited = new boolean[N];

        dfs(0);
        System.out.println(ans);
    }
  
    public static void dfs(int cnt) {
        if (cnt == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            if(!visited[i]) {
                for (int j = 0; j < cnt ; j++) {
                    if (Math.abs(i-index[j]) == Math.abs(cnt-j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    index[cnt] = i;
                    visited[i] = true;
                    dfs(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}
