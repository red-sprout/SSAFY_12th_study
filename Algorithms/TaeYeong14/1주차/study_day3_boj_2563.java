import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int[][] arr = new int[100][100];

        for (int n = 0; n < num; n++) {
            String[] coordinates = reader.readLine().split(" ");
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    arr[x1 + i][y1 + j] = 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                result += arr[i][j];
            }
        }

        System.out.println(result);
    }
}
