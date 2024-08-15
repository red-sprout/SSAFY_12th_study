package week5;

import java.io.*;
import java.util.*;
 
class Solution_10761_신뢰 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
         
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
             
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] pos = {1, 1};
             
            Queue<int[]> q = new ArrayDeque<>();
            Queue<Integer> blue = new ArrayDeque<>();
            Queue<Integer> orange = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
                char robot = st.nextToken().charAt(0);
                int btn = Integer.parseInt(st.nextToken());
                int idx = robot == 'B' ? 0 : 1;
                q.offer(new int[] {idx, btn});
                if(robot == 'B') {
                    blue.offer(btn);
                } else {
                    orange.offer(btn);
                }
            }
             
            int answer = 0;
            while(!q.isEmpty()) {
                int[] op = q.poll();
                int idx = op[0];
                int btn = op[1];
                int time = 0;
                if(idx == 0) {
                    time = Math.abs(pos[0] - btn) + 1;
                    pos[0] = btn;
                    if(orange.size() > 0) {                      
                        if(time >= Math.abs(pos[1] - orange.peek())) {
                            pos[1] = orange.peek();
                        } else if(pos[1] > orange.peek()) {
                            pos[1] -= time;
                        } else {
                            pos[1] += time;
                        }
                    }
                    blue.poll();
                } else {
                    time = Math.abs(pos[1] - btn) + 1;
                    pos[1] = btn;
                    if(blue.size() > 0) {                        
                        if(time >= Math.abs(pos[0] - blue.peek())) {
                            pos[0] = blue.peek();
                        } else if(pos[0] > blue.peek()) {
                            pos[0] -= time;
                        } else {
                            pos[0] += time;
                        }
                    }
                    orange.poll();
                }
                answer += time;
            }
            sb.append(answer).append("\n");
        }
         
        System.out.print(sb.toString());
        br.close();
    }
}