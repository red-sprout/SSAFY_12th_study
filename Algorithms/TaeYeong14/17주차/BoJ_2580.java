import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws Exception {
		    // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 실행
        solveSudoku(0, 0);
    }

    public static boolean solveSudoku(int row, int col) {
        if (row == 9) { // 모든 행을 탐색 완료한 상태 - 스도쿠 완성!
		        // 출력
            printBoard();
            return true; // 탐색 종료
        }

        if (col == 9) { // 열의 끝에 도달했을 때
            return solveSudoku(row + 1, 0); // 다음 행으로 이동
        }

        if (board[row][col] != 0) { // 이미 채워진 칸인 경우
            return solveSudoku(row, col + 1); // 다음 열로 이동
        }

        for (int num = 1; num <= 9; num++) { // 1부터 9까지 숫자 넣기 시도
            if (isSafe(row, col, num)) { // 조건을 만족하는 경우
                board[row][col] = num; // 빈칸에 해당 숫자 채우고
                if (solveSudoku(row, col + 1)) { // 다음 칸으로 이동해서 탐색
                    return true; // 현재 칸에 숫자를 배치하고 나서 나머지 모든 칸도 성공적으로 채워진 경우 return true
                }
                board[row][col] = 0; // 불가능한 경우에는 다시 빈칸으로 설정
            }
        }
        return false; // 유효한 경우가 없는 경우
    }

		// 유효성 검사 메소드
    public static boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
		        // 같은 행, 열에 num이 존재하는지 체크
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

				
        // (row, col)이 속한 3x3 그리드 시작 위치
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        // 3x3 그리드에 num이 존재하는지 확인
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

		// 결과 출력 메소드
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
