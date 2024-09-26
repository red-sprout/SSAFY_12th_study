import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nNums, mNums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nNums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nNums[n] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(nNums);

        M = Integer.parseInt(br.readLine());
        mNums = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            mNums[m] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            if (binarySearch(nNums, mNums[i])) {
                System.out.println(1); // 찾으면 1
            } else {
                System.out.println(0); // 못 찾으면 0
            }
        }
    }

    public static boolean binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == num) {
                return true; // 값을 찾음
            } else if (arr[mid] < num) {
                left = mid + 1; // 중간값이 찾는 값보다 작으면 오른쪽으로 이동
            } else {
                right = mid - 1; // 중간값이 찾는 값보다 크면 왼쪽으로 이동
            }
        }
        return false; // 값을 찾지 못함
    }
}
