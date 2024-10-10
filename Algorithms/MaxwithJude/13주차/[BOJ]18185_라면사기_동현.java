package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr [] = new int[n+2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int idx = 0;
		
//		for(int i = 0; i < n; i++) {
//			
//			//3개 연속
//			if(i+2 < n && arr[i] > 0 && arr[i+1]>0 && arr[i+2] >0) {
//				int set3 = Math.min(arr[i],Math.min(arr[i+1], arr[i+2]));
//				arr[i] -= set3;
//				arr[i+1] -= set3;
//				arr[i+2] -= set3;
//				//입체적으로 생각해야한다. 예를 들어 4 6 3 이면 3번 연속 뺄 수 있으므로 7의 비용으로 3번 가능
//				ans += set3 * 7;
//			}
//			//2개 연속
//			if(i+1 < n && arr[i] > 0 && arr[i+1]>0) {
//				int set2 = Math.min(arr[i], arr[i+1]);
//				arr[i] -= set2;
//				arr[i+1] -= set2;
//				ans+= set2 * 5;
//			}
//			//1개
//			if(arr[i] > 0) {
//				ans += arr[i]*3;
//			}
//		}
		//이게 왜 안되는데ㅔ?!
		while(idx < n) {
			if(arr[idx] > 0) {
				int tmp = arr[idx];
				ans += tmp * 3;
				tmp = Math.min(tmp, arr[idx+1]);
				ans+= tmp * 2;
				arr[idx+1] -= tmp;
				tmp = Math.min(tmp, arr[idx+2]- Math.min(arr[idx+1], arr[idx+2]));
				ans+= tmp * 2;
				arr[idx+2] -= tmp;
				
			}idx++;
		}
		//이게 왜 되는데??
		System.out.println(ans);
	}
}
