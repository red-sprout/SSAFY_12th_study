import java.io.*;
import java.util.*;

2weekBoj13335

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        int count = 0;
        int bridgeWeight = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken())); // 트럭의 무게를 큐에 담음
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0); // 현재 다리에 올라와있는 트럭의 무게
        }

        while (!bridge.isEmpty()) { // 현재 다리에 올라와 있는 트럭이 존재하지 않을 때 까지
            count++; // 로직이 진행될 때 마다 시간이 1씩 증가
            bridgeWeight-=bridge.poll(); // 다리에 올라와있는 트럭이 한대 씩 다리에서 내려옴 , queue.poll() : 큐의 맨 앞의 값 추출
            if (!truck.isEmpty()) { // 큐에 담긴 트럭이 존재하지 않을 때 까지
                if (truck.peek() + bridgeWeight <= L) { // 트럭큐에 담긴 맨앞의 값과 현재 다리위에 올라와있는 트럭의 무게의 합이 L 보다 낮을때 , queue.peek() : 큐의 맨 앞의 값 확인
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll()); // 다리에 한 대 씩 올라감
                } else {
                    bridge.add(0); // 트럭큐에 트럭이 존재하지만 다리의 최대하중 때문에 다리로 못올라갈 경우 truck.poll()은 하지 않는다.
                }
            }
        }
        System.out.println(count);

    }
}
