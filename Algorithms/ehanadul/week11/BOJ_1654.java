import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //[백준] 1654. 랜선자르기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        long[] lengths = new long[K];
        long maxLength = 0;


        for (int i = 0; i < K; i++) {
            lengths[i] = Long.parseLong(br.readLine());
            maxLength = Math.max(maxLength, lengths[i]);
        }

        //이분탐색
        long left = 1;
        long right = maxLength;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            //현재길이로 자를 수 있는 랜선 수
            for (long length : lengths) {
                count += length / mid;
            }


            if (count >= N) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        System.out.println(result);
    }
}