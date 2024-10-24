import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());  // 행의 개수
        int C = Integer.parseInt(st.nextToken());  // 열의 개수

        char[][] arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int left = 0;
        int right = R - 1;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canRemoveRows(arr, R, C, mid)) {
                result = mid;  // 이만큼 제거할 수 있음
                left = mid + 1;  // 더 많은 행을 제거할 수 있는지 확인
            } else {
                right = mid - 1;  // 중복이 발생했으므로 더 적은 행을 제거해야 함
            }
        }

        System.out.println(result);
    }

    // 특정 개수만큼의 행을 제거했을 때 중복이 발생하는지 확인하는 함수
    private static boolean canRemoveRows(char[][] arr, int R, int C, int removeCount) {
        HashSet<String> set = new HashSet<>();

        // removeCount 만큼 행을 제거한 후 열을 읽어 문자열을 만듦
        for (int col = 0; col < C; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = removeCount; row < R; row++) {
                sb.append(arr[row][col]);
            }

            String columnString = sb.toString();
            if (!set.add(columnString)) {
                return false;  // 중복이 발생하면 false 반환
            }
        }

        return true;  // 중복이 없으면 true 반환
    }
}
