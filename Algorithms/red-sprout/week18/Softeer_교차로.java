import java.io.*;
import java.util.*;

public class Main {
    static class Car {
        int id, time, idx;
        Car(int id, int time, int idx) {
            this.id = id;
            this.time = time;
            this.idx = idx;
        }
        @Override
        public String toString() {
            return "Car(" + id + ")-" + time;
        }
    }
    static Queue<Car>[] roads;
    static HashMap<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        map.put('D', 0);
        map.put('C', 1);
        map.put('B', 2);
        map.put('A', 3);
        roads = new Queue[4];
        for(int i = 0; i < 4; i++) {
            roads[i] = new ArrayDeque<>();
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            char w = st.nextToken().charAt(0);
            int idx = map.get(w);
            Car car = new Car(i, t, idx);
            roads[idx].offer(car);
        }
        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        int time = -1;
        int[] lazy = new int[4];
        while(true) {
            if(roads[0].isEmpty() && roads[1].isEmpty() && roads[2].isEmpty() && roads[3].isEmpty()) break;
            int cnt = 0;
            int min = Integer.MAX_VALUE;
            Arrays.fill(lazy, 0);
            for(int i = 0; i < 4; i++) {
                Car car = roads[i].peek();
                if(car == null) continue;
                min = Math.min(min, car.time);
                if(car.time <= time) {            
                    lazy[i] = 1;
                    cnt++;
                }
            }
            if(cnt == 4) break;
            if(cnt == 0) {
                time = min;
                continue;
            }
            for(int i = 0; i < 4; i++) {
                if(lazy[i] == 1 && lazy[(i + 1) % 4] == 0) {
                    Car car = roads[i].poll();
                    answer[car.id] = time;
                }
            }
            time++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
