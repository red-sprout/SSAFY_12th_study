package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    //BOJ_4485_녹색 옷 입은 애가 젤다지?
    static int N,tc;
    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder  sb = new StringBuilder();
    tc =1;
        while(true){
            N=Integer.parseInt(br.readLine());
            if(N==0) break;

            map = new int[N][N];
            dist = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            sb.append("Problem ").append(tc++).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        pq.add(new int[]{0,0,map[0][0]});
        dist[0][0] = map[0][0];

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            //목적지 도착
            if(x==N-1 && y==N-1){
                return cost;
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];


                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    int newCost = cost + map[nx][ny];

                    //업데이트
                    if(newCost < dist[nx][ny]){
                        dist[nx][ny] = newCost;
                        pq.add(new int[]{nx,ny,newCost});
                    }
                }
            }
        }
        return -1;
    }

}
