package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 

public class SWEA_1926 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
 
        StringBuilder sb = new StringBuilder();
 
        for (int number = 1; number <= N; number++) {
            String strNum = String.valueOf(number);
            int count = 0;
 
            for (char ch : strNum.toCharArray()) {
                if (ch == '3' || ch == '6' || ch == '9') {
                    count++;
                }
            }
 
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    sb.append("-");
                }
            } else {
                sb.append(number);
            }
            sb.append(" ");
        }
 
        System.out.print(sb.toString());
    }
}