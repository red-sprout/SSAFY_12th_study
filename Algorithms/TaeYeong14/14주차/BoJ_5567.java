import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] friends;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 동기 수
        int m = Integer.parseInt(br.readLine()); // 리스트 길이

        // 친구 관계를 나타낼 그래프 (인접 리스트)
        friends = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            friends[i] = new ArrayList<>();
        }

        // 친구 관계 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a].add(b);
            friends[b].add(a);
        }

        // BFS 탐색 및 결과 출력
        System.out.println(bfs(1, n));
    }

    // BFS 메소드
    static int bfs(int start, int n) {
        visited = new boolean[n + 1];  // 방문 여부 기록
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start] = true;  // 상근이(1번)
        queue.add(start);

        int inviteCount = 0;
        int depth = 0;

        while (!queue.isEmpty() && depth < 2) {  // 친구와 친구의 친구까지만 탐색
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int friend : friends[current]) {
                    if (!visited[friend]) {
                        visited[friend] = true;
                        queue.add(friend);
                        inviteCount++;
                    }
                }
            }
            depth++;
        }
        return inviteCount;
    }
}
