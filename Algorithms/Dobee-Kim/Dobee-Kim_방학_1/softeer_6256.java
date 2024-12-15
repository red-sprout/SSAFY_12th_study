package dec_1st;

import java.io.*;
import java.util.*;

// 나중에 비트마스킹으로 수정해보기

public class softeer_6256 {
	static int N, presentTime;
	static StringTokenizer st;
	static String[] relation = {"A", "D", "C", "B"};
	static int[] rel = {0,3,2,1};
	// 자신을 기준으로 오른쪽에 위치한 도로에 차량이 있으면 1초동안 출발 X
	// 차량 없으면 즉시 통과
	// A-D B-A C-B D-C -> A-D D-C C-B B-A 연결	
	
	// ABCD에 한 대 이상씩 있다면 -> 교착상태
	// t초대 진입 + 대기 없으면 바로 출발
	// 같은 시각에 각 위치에 진입할 수 있는 차량은 최대 한 대
	
	// 아이디어 고민
	// q에 넣고 빼기?
	// 같은 시간대의 애들을 한꺼번에 확인해야함
	// 이차원 배열은?
	// 시간초과때문에 한큐에 해결하는게 좋을 듯
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Integer> chkList = new ArrayDeque<Integer>(); // 순서대로 값 유지
		boolean[] exist = new boolean[4]; // 존재 여부 (idx = A,B,C,D)
		int pastT = -1;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpT = Integer.parseInt(st.nextToken());
			int loc = changeNum(st.nextToken());
			
			// 확인한 값이 이전 기록과 같으면 같이 체크할 셋에 넣기
			// 문제는 출력을 위해 순서를 유지해야함 (즉 계산과 출력이 별개)
			if (pastT != tmpT) {
			// 이전 기록과 다르면, 여태껏 모았던 교차로 리스트를 통해 현재 시간 추정하고 print 후 리스트 초기화
				// 연속된 수가 있으면 -> 순차적 진행
				
				// 연속된 수가 없으면 -> 동시 진행
				
				// 4가지 다 true라면 -> 교착상태
				
				// 초기화
				chkList.clear();
				exist = new boolean[4];
				pastT = tmpT;
			}
			
			chkList.offer(loc);
			exist[loc] = true;
			
		}
	}
	private static int changeNum(String str) {
		switch (str) {
		case "A":
			return 1;
		case "B":
			return 2;
		case "C":
			return 3;
		case "D":
			return 4;
		}
		return -1;
	}
}
