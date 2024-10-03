package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    //[백준] 13549. 숨바꼭질3
    static int N,K;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(N,K));
    }
    private static int dijkstra(int n, int k) {
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.offer(new int[] {n,0});
        dist[n] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int position = cur[0];
            int time = cur[1];

            //잡은 경우
            if(position == k){
                return time;
            }
            //순간이동
            if(position*2 < dist.length && dist[position*2] > time){
                dist[position*2] = time;
                pq.offer(new int[] {position*2,time});
            }

            //왼쪽이동
            if(position-1 >= 0 && dist[position-1] > time+1){
                dist[position-1] = time+1;
                pq.offer(new int[] {position-1,time+1});
            }

            //오른쪽이동
            if(position+1 < dist.length && dist[position+1] > time+1){
                dist[position+1] = time+1;
                pq.offer(new int[] {position+1,time+1});
            }

        }
        return -1;


    }
}
