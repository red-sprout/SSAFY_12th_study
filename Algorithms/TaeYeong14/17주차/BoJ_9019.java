import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
		    // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 초기값
            int B = Integer.parseInt(st.nextToken()); // 목표값
            // 실행
            sb.append(bfs(A, B)).append("\n");
        }
				// 출력
        System.out.print(sb.toString());
    }
    
    static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000]; // 지스터가 저장할 수 있는 값의 범위가 0 이상 10,000 미만
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, "")); // 각 정수를 Node 객체로 관리
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

						// 목표 도달했을 때
            if (current.value == target) {
                return current.path; // 경로 반환
            }
						
						// D 연산
            int D = (current.value * 2) % 10000;
            if (!visited[D]) { // 값 D에 해당하는 숫자에 이미 도달하지 않았다면
                visited[D] = true; // 방문처리
                queue.add(new Node(D, current.path + "D")); // 큐에 추가해 탐색 진행
            }

						// S 연산
            int S = (current.value == 0) ? 9999 : current.value - 1;
            if (!visited[S]) {
                visited[S] = true;
                queue.add(new Node(S, current.path + "S"));
            }

						// L 연산
            int L = (current.value % 1000) * 10 + current.value / 1000;
            if (!visited[L]) {
                visited[L] = true;
                queue.add(new Node(L, current.path + "L"));
            }

						// R 연산
            int R = (current.value % 10) * 1000 + (current.value / 10);
            if (!visited[R]) {
                visited[R] = true;
                queue.add(new Node(R, current.path + "R"));
            }
        }

        return "";
    }

    static class Node {
        int value;
        String path;

        Node(int value, String path) {
            this.value = value; // 값
            this.path = path; // 경로
        }
    }
}
