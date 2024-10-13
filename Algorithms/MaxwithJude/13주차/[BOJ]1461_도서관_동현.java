import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> plusqu = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusqu= new PriorityQueue<>(Collections.reverseOrder());
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int no = sc.nextInt();
			if(no >= 0) {
				//읽는 수가 양수면 양수 큐
				plusqu.offer(no);
			}else {
				minusqu.offer(Math.abs(no));
			}
		}
		//먼 거리 
		int far = 0;
		if(plusqu.isEmpty()) far = minusqu.peek();
		else if(minusqu.isEmpty()) far = plusqu.peek();//털기
		else {
			far = Math.max(minusqu.peek(), plusqu.peek());
			}
		
		//이동거리
		int dis = 0;
		while(!plusqu.isEmpty()) {
			//빌때까지
			dis += plusqu.peek() * 2;
			for(int i = 0; i < m; i++) {
				plusqu.poll();
			}
		
		}
		
		while(!minusqu.isEmpty()) {
			dis += minusqu.peek() * 2;
			for(int i = 0; i < m; i++) {
				minusqu.poll();
			}
		}
		
		dis -= far; //가장 긴거는 마지막으로 꽂아서 돌아올 필요가 없으므로 간건 유지하고 돌아올 것을 계산한 만큼 빼준다.
		System.out.println(dis);
		//한 집단에서 가장 큰수의 2배가 결국 그 집단이 꽂고나서 다시 책을 가지러 가는 과정이므로 두 배
		
		sc.close();
		
		
	}
}
