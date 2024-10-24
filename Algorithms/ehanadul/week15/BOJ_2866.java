package nana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2866 {
 //[BOJ] 2866. 문자열 잘라내기;

    static char[][] table;
    static int R,C,count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        table = new char[R][C];
        
        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                table[i][j] = str.charAt(j);
            }
        }//입력 끝
       
        count = search(R, C);
        System.out.println(count);
        
        br.close();
    }
    
    //이분탐색
    static int search(int R, int C){
        int start = 0;
        int end = R - 1;
      
        while(start <= end){
            int mid = (start + end) / 2;

            if(check(mid, R, C)){
                start = mid + 1;
            }else{	
                end = mid - 1;
            }
        }
        return start;	
    }
   //중복 문자열 확인
    static boolean check(int mid, int R, int C){
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<C;i++){
            StringBuilder str = new StringBuilder();
           
            for(int j=mid+1;j<R;j++){
                str.append(table[j][i]);
            }
           
            if(set.contains(str.toString())){
                return false;//중복
            }
            
            set.add(str.toString());
        }
        return true;//중복X
    }
}