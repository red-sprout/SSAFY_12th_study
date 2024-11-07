import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append("\n");
        }

        System.out.print(sb.toString());
    }
    
    static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, ""));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
          
            // 목표 값에 도달했으면 명령어 나열 반환
            if (current.value == target) {
                return current.path;
            }

            // D 명령어 적용: 값의 두 배 후 10000으로 나눈 나머지 저장
            int D = (current.value * 2) % 10000;
            if (!visited[D]) { // 아직 방문하지 않았다면
                visited[D] = true;
                queue.add(new Node(D, current.path + "D")); // 큐에 새로운 상태와 경로 추가
            }

            // S 명령어 적용: 1을 뺀 값, 0일 경우 9999로 설정
            int S = (current.value == 0) ? 9999 : current.value - 1;
            if (!visited[S]) {
                visited[S] = true;
                queue.add(new Node(S, current.path + "S"));
            }

            // L 명령어 적용: 네 자릿수 왼쪽으로 회전
            int L = (current.value % 1000) * 10 + current.value / 1000;
            if (!visited[L]) {
                visited[L] = true;
                queue.add(new Node(L, current.path + "L"));
            }

            // R 명령어 적용: 네 자릿수 오른쪽으로 회전
            int R = (current.value % 10) * 1000 + (current.value / 10);
            if (!visited[R]) {
                visited[R] = true;
                queue.add(new Node(R, current.path + "R"));
            }
        }

        return ""; // 모든 경우를 탐색해도 목표 값에 도달하지 못한 경우 (유효한 입력에서는 도달함)
    }

    static class Node {
        int value; // 현재 레지스터 값
        String path; // 명령어 나열

        Node(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }
}
