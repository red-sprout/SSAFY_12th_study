import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board = new char[5][5];
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        // 모든 가능한 자리 조합 탐색
        dfs(new ArrayList<>(), 0, 0);
        
        System.out.println(result);
    }
    
    // 백트래킹으로 자리 조합을 선택
    static void dfs(ArrayList<int[]> selected, int start, int sCount) {
        if (selected.size() == 7) {
            // 7명의 자리가 인접한지 확인하고, 이다솜파가 4명 이상인지 체크
            if (sCount >= 4 && isAdjacent(selected)) {
                result++;
            }
            return;
        }
        
        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;
            selected.add(new int[]{x, y});
            dfs(selected, i + 1, sCount + (board[x][y] == 'S' ? 1 : 0));
            selected.remove(selected.size() - 1);  // 선택 해제
        }
    }
    
    // BFS를 이용해 7개의 자리가 인접한지 확인
    static boolean isAdjacent(ArrayList<int[]> selected) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(selected.get(0));
        visited[selected.get(0)[0]][selected.get(0)[1]] = true;
        int count = 1;
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (!visited[nx][ny] && contains(selected, nx, ny)) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count++;
                    }
                }
            }
        }
        return count == 7; // 7개가 모두 연결되었는지 확인
    }
    
    // 선택된 자리에 포함되어 있는지 확인
    static boolean contains(ArrayList<int[]> selected, int x, int y) {
        for (int[] pos : selected) {
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }
        return false;
    }
}
