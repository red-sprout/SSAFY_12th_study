package binarySearch;
import java.io.*;
import java.util.*;

public class BOJ_1654 {
	static int K, N;
	static long maxLen;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		K = Integer.parseInt(st[0]);
		N = Integer.parseInt(st[1]);
		maxLen = 0;
		for(int i=0;i<K;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		long start = 1;
		long end = arr.get(K-1); // 가장 작은 숫자로 나누면 최댓값으로 자를 수 있음
		long mid = (start+end) / 2;
		
		while(start<=end) {
			mid = (start+end) / 2;
			int cnt = findCnt(mid);
			
			if (cnt >= N) {
				start = mid+1;
				maxLen = mid;
			} else {
				end = mid-1;
			}
			
		}
		
		System.out.println(maxLen);
	}
	
	static int findCnt(long st) {
		int cnt=0;
		for(int j=0;j<K;j++) {
			cnt += arr.get(j) / st;
		}

		return cnt;
	
	}
}
