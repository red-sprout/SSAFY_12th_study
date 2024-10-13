import java.io.*;
import java.util.*;

public class Main_bj_1461_도서관 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> plus = new ArrayList<>();
		List<Integer> minus = new ArrayList<>();
		plus.add(0);
		minus.add(0);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			if(pos > 0) {
				plus.add(pos);
			} else {
				minus.add(-pos);
			}
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus, Collections.reverseOrder());
		int mIdx = 0;
		int pIdx = 0;
		int answer = 0;
		boolean isFirst = true;
		while(true) {
			if(plus.size() - pIdx <= M && minus.size() - mIdx <= M) break;
			int tmp = 2;
			if(isFirst) {
				tmp = 1;
				isFirst = false;
			}
			int pValue = plus.get(pIdx);
			int mValue = minus.get(mIdx);
			if(plus.size() - pIdx < M) {
				answer += tmp * mValue;
				mIdx += M;
				continue;
			}
			if(minus.size() - mIdx < M) {
				answer += tmp * pValue;
				pIdx += M;
				continue;
			}
			if(pValue > mValue) {
				answer += tmp * pValue;
				pIdx += M;
			} else {
				answer += tmp * mValue;
				mIdx += M;
			}
		}
		if(isFirst) {
			answer += 2 * Math.min(plus.get(pIdx), minus.get(mIdx)) + Math.max(plus.get(pIdx), minus.get(mIdx));
		} else {
			answer += 2 * (plus.get(pIdx) + minus.get(mIdx));
		}
		System.out.println(answer);
		br.close();
	}
}
