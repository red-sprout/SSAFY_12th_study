package week2;

import java.io.*;
import java.util.*;

public class BOJ1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Double> stack = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		double[] arr = new double[26];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'A' && c <= 'Z') {
				stack.push(arr[c - 'A']);
			} else {
				double b = stack.pop();
				double a = stack.pop();
				stack.push(calc(a, b, c));
			}
		}
		
		System.out.printf("%.2f", stack.pop());
		br.close();
	}
	
	public static double calc(double a, double b, char c) {
		switch(c) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		default:
			return a / b;
		}
	}
}
