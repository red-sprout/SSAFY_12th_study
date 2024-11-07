import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solveSudoku(0, 0);
    }

    public static boolean solveSudoku(int row, int col) {
        // 모든 행을 다 채운 경우, 스도쿠 완성
        if (row == 9) {
            printBoard(); // 완성된 보드 출력
            return true;
        }
      
        // 열이 9에 도달한 경우 다음 행의 첫 번째 열로 이동
        if (col == 9) {
            return solveSudoku(row + 1, 0);
        }
      
        // 이미 숫자가 채워진 칸인 경우 다음 칸으로 이동
        if (board[row][col] != 0) {
            return solveSudoku(row, col + 1);
        }

        for (int num = 1; num <= 9; num++) {
            // 현재 숫자를 놓아도 규칙을 만족하는지 확인
            if (isSafe(row, col, num)) {
                board[row][col] = num; // 숫자 놓기
                // 다음 칸으로 이동하며 재귀 호출
                if (solveSudoku(row, col + 1)) {
                    return true; // 정답을 찾은 경우 true 반환
                }
                board[row][col] = 0; // 실패한 경우 다시 0으로 초기화 (백트래킹)
            }
        }
        return false;
    }

    public static boolean isSafe(int row, int col, int num) {
        // 같은 행과 열에 num이 존재하는지 확인
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // 3x3 작은 구역에서 num이 존재하는지 확인
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false; 
                }
            }
        }
        return true; // 놓아도 되는 경우 true 반환
    }

    public static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
