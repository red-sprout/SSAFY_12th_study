package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
 
public class SWEA_1288 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            Set<Character> num = new HashSet<>();
            int cnt =0;
             
            while(num.size() < 10) {
                cnt++;
                long mul = N*cnt;
                for(char digit : String.valueOf(mul).toCharArray()) {
                    num.add(digit);
                }
            }
            System.out.printf("#%d %d\n",tc, cnt*N);
        }
    }
 
}