package nana;

import java.io.*;
import java.util.*;

public class Softeer_교차로 {
	static class Car {
		int id;
		int inTime;

		Car(int a, int b) {
			id = a;
			inTime = b;
		}
	}

	static int N;
    static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(in.readLine());
        arr = new int[N];
        Arrays.fill(arr, -1);
		Queue<Car>[] q = new Queue[4];
		for (int i = 0; i < 4; ++i)
			q[i] = new ArrayDeque();

		for (int i = 0; i < N; ++i) {
			String[] inputs = in.readLine().split(" ");
            int dir = inputs[1].charAt(0) - 'A';
			q[dir].add(new Car(i, stoi(inputs[0])));
		}

        int currentTime = -1;
        while(true){
        	// 모든 차량 통과
            if(q[0].isEmpty() && q[1].isEmpty() && q[2].isEmpty() && q[3].isEmpty())
                break;

            int[] state = new int[4];
            int minTime = Integer.MAX_VALUE;
            for(int i = 0; i < 4; ++i){
                if(!q[i].isEmpty()){
                    int t = q[i].peek().inTime;
                    minTime = Math.min(t, minTime);
                    if(t <= currentTime)
                        state[i] = 1;
                }
            }
            int count = 0;
            for(int value : state)
                count += value;
            
            if(count == 0){
            	// 어떤 차량도 아직 교차로에 진입하지 않음.
                // 가장 빠른 차량의 시간으로 점프
                currentTime = minTime;
            } else if(count == 4)
            	// 모든 차량에 교차로에서 대기중 -> 교착상태
                break;
            else{
                for(int i = 0; i < 4; ++i){
                    // 현재 방향에서 진행 가능하며, 오른쪽은 불가능 할 때
                    if(state[i] != 0 && state[(i+3) % 4] == 0){
                        arr[q[i].poll().id] = currentTime;
                    }
                }
                currentTime += 1;
            }
        }
        
		for (int i = 0; i < N; ++i)
			sb.append(arr[i]).append("\n");

		System.out.println(sb);
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
