package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	static int n;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[2][n];	
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
		}
		//입력끝
		//제외 먼저?
		int maxsum = 0; //출력할 값
		int dp [] = new int[n+1];
		
		for(int i = n-1; i >= 0; i--) {
			int ableday = i + arr[0][i];
			//가능한 날이면 더 하기
			if(ableday <= n) {
				dp[i] += arr[1][i];
			}
		}
		
		System.out.println(maxsum);
		
		
	}
}
