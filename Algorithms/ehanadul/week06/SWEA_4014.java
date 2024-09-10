package swea;

import java.util.*;
import java.io.*;

public class SWEA_4014 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); 
        
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int X = Integer.parseInt(st.nextToken()); 
            
            int[][] map = new int[N][N]; // 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) 
                    map[i][j] = Integer.parseInt(st.nextToken()); 
            }
            
            int runwayCount = 0; // 가능한 활주로 수
            
            // 행
            next: for (int i = 0; i < N; i++) {
                int cnt = 1; // 연속된 높이의 개수
                boolean down = false; // 현재 내리막인지 확인
                
                for (int j = 1; j < N; j++) {
                    if (map[i][j - 1] == map[i][j]) 
                        cnt++; // 높이가 같으면 카운트 증가
                    else if (map[i][j - 1] + 1 == map[i][j]) { // 오르막
                        if (down && cnt < 2 * X) continue next; // 내리막 후 경사로 필요
                        if (!down && cnt < X) continue next; // 오르막 경사로 필요
                        down = false; // 내리막 아님
                        cnt = 1; // 새 구간 시작
                    } else if (map[i][j - 1] - 1 == map[i][j]) { // 내리막
                        if (down && cnt < X) continue next; // 내리막 후 경사로 필요
                        down = true; // 내리막으로 설정
                        cnt = 1; // 새 구간 시작
                    } else {
                        continue next; // 높이 차이가 1이 아닌 경우
                    }
                }
                
                // 마지막 구간 체크
                if (!down || (down && cnt >= X)) 
                    runwayCount++; // 활주로 가능
            }
            
            // 열
            next: for (int i = 0; i < N; i++) {
                int cnt = 1; // 연속된 높이의 개수
                boolean down = false; // 현재 내리막인지 확인
                
                for (int j = 1; j < N; j++) {
                    if (map[j - 1][i] == map[j][i]) 
                        cnt++; // 높이가 같으면 카운트 증가
                    else if (map[j - 1][i] + 1 == map[j][i]) { // 오르막
                        if (down && cnt < 2 * X) continue next; // 내리막 후 경사로 필요
                        if (!down && cnt < X) continue next; // 오르막 경사로 필요
                        down = false; // 내리막 아님
                        cnt = 1; // 새 구간 시작
                    } else if (map[j - 1][i] - 1 == map[j][i]) { // 내리막
                        if (down && cnt < X) continue next; // 내리막 후 경사로 필요
                        down = true; // 내리막으로 설정
                        cnt = 1; // 새 구간 시작
                    } else {
                        continue next; // 높이 차이가 1이 아닌 경우
                    }
                }
                
                // 마지막 구간 체크
                if (!down || (down && cnt >= X)) 
                    runwayCount++;
            }
            
            System.out.println("#" + t + " " + runwayCount);
        }
    }
}
