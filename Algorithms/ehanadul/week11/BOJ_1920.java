import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //[백준]1920. 수 찾기
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int m = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int target = scanner.nextInt();
            if (binarySearch(arr, target)) {
                result.append("1\n");
            } else {
                result.append("0\n");
            }
        }

        System.out.print(result);
    }

    //이분탐색
    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}