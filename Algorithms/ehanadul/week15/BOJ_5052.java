package nana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BOJ_5052 {
	//[BOJ]5052.전화번호 목록
	
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        StringBuilder sb  =new StringBuilder();
        for(int i=0; i<n; i++){
            int size = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            String [] str = new String[size];
 
            for(int j=0; j<size; j++){
                str[j] = br.readLine();
                map.put(str[j],0);
            }
 
            Arrays.sort(str);
 
            boolean flag = true;
 
            for(int j=1; j<size; j++){
                for(int k=1; k<str[j].length(); k++){
                    if(map.containsKey(str[j].substring(0,k))){
                        flag = false;
                        break;
                    }
                }
                if(!flag){
                    break;
                }
            }
            if(flag){
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
 
        }
 
        System.out.println(sb.toString());
 
    }
 
}