import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[] items;
    static List<int[]>[] graph;
    
    public static void main(String[] args) throws Exception {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // 지역 수
        m = Integer.parseInt(st.nextToken());  // 수색 범위
        r = Integer.parseInt(st.nextToken());  // 길의 개수

        items = new int[n + 1]; // 지역별 아이템 수
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 길 정보
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[a].add(new int[] {b, l});
            graph[b].add(new int[] {a, l});
        }
        
        // 실행
        // 각 지역에서의 최대 아이템 수를 구하고 그 중 최댓값을 찾기
        int maxItems = 0;
        for (int i = 1; i <= n; i++) {
            maxItems = Math.max(maxItems, bfs(i));
        }

        // 결과 출력
        System.out.println(maxItems);
    }

    // BFS 메소드
    static int bfs(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[] {start, 0});
        
        boolean[] visited = new boolean[n + 1]; // 방문 배열
        
        int totalItems = 0; // 아이템 수 합계
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int dist = current[1];

            if (visited[node]) {
                continue;
            }

            visited[node] = true; // 방문 처리
            
            totalItems += items[node]; // 아이템 획득
            
            for (int[] neighbor : graph[node]) {
                int nextNode = neighbor[0];
                int nextDist = dist + neighbor[1];
                
                if (!visited[nextNode] && nextDist <= m) {
                    pq.add(new int[] {nextNode, nextDist});
                }
            }
        }
        
        return totalItems;
    }
}
