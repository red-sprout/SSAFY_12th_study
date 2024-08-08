package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class BOJ_15686 {

    static int N, M;
    static ArrayList<Point> chicken = new ArrayList<>(); // 치킨집 위치
    static ArrayList<Point> house = new ArrayList<>(); // 집 위치
    static boolean[] visited; //치킨집 체크
    static int min = Integer.MAX_VALUE; // 최소 치킨거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) house.add(new Point(i, j));
                else if (value == 2) chicken.add(new Point(i, j));
            }
        }

        visited = new boolean[chicken.size()];
        backtracking(0, 0); // 백트래킹
        System.out.println(min);
    }

    public static void backtracking(int count, int idx) {
        if (count == M) {
            int sum = 0; // 치킨 거리 합
            for (Point h : house) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) { // 선택된 치킨집만 고려
                        int dist = Math.abs(h.x - chicken.get(j).x) + Math.abs(h.y - chicken.get(j).y);
                        min = Math.min(min, dist);
                    }
                }
                sum += min; //최소 거리 합산
            }
            min = Math.min(sum, min);
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}