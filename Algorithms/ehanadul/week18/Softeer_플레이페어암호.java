package nana;

import java.util.*;
import java.io.*;

public class Softeer_플레이페어암호 {
    static char[][] board;
    static boolean[] check;
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        board = new char[5][5];
        String message, key;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        message = br.readLine();
        key = br.readLine();

        check = new boolean[26]; 
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //5x5 표를 채운다.
        //PLAYFAIRCIPHERKEY

        check['J'-'A'] = true;
        int idx = 0;
        for(int i=0; i<key.length(); i++){
            char c = key.charAt(i);
            if(check[c-'A']) continue;
            board[idx/5][idx%5] = c;
            check[c-'A'] = true;
            idx++;
        }

        //사용되지 않은 알파벳 차례대로 채우기
        for(int i=0; i<26; i++){
            if(check[i]) continue;
            board[idx/5][idx%5] = (char)(i+'A');
            idx++;
        }

        //암호화하려는 메시지를 2자씩 나눈다
        //HE L LO WO RL D
        //HE LX LO WO RL DX
        List<String> tokens = new ArrayList<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<message.length(); i++){
            q.offer(message.charAt(i));
        }
        while(!q.isEmpty()){
            char c1 = q.poll();
            if(q.isEmpty()){
                tokens.add(String.valueOf(c1)+"X");
                break;
            }
            if(c1==q.peek()){
                char c2 = 'X';
                if(c1=='X'){
                    c2 = 'Q';
                }
                tokens.add(String.valueOf(c1)+String.valueOf(c2));
            }
            else{
                char c2 = q.poll();
                tokens.add(String.valueOf(c1)+String.valueOf(c2));
            }
        }

        //암호화하기
        String encrypted = "";
        for(String t:tokens){
            char c1 = t.charAt(0);
            char c2 = t.charAt(1);

            Point p1 = find(c1);
            Point p2 = find(c2);

            //1. 같은 행에 존재한다면 오른쪽으로 한칸 이동한 문자로
            if(p1.r==p2.r){
                c1 = board[p1.r][(p1.c+1)%5];
                c2 = board[p2.r][(p2.c+1)%5];
                encrypted += String.valueOf(c1)+String.valueOf(c2);
            }else if(p1.c==p2.c){
                //2. 같은 열에 존재한다면 아래쪽으로 한칸 이동한 문자로
                c1 = board[(p1.r+1)%5][p1.c];
                c2 = board[(p2.r+1)%5][p2.c];
                encrypted += String.valueOf(c1)+String.valueOf(c2);
            }
            else{
                //3. 두 문자의 열 위치가 교환된 문자로
                c1 = board[p1.r][p2.c];
                c2 = board[p2.r][p1.c];
                encrypted += String.valueOf(c1)+String.valueOf(c2);
            }
        }

        System.out.println(encrypted);
    }    

    public static Point find(char c){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]==c){
                    return new Point(i, j);
                }
            }
        }

        return new Point(0, 0);
    }
}