import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		ArrayList<Integer> num_arr = new ArrayList<>();
		while(num > 0) {
			num_arr.add(num %10);
			num /= 10;
		}
		
		int[] count_arr = new int[10];
		Arrays.fill(count_arr, 0);
		
		for (int n : num_arr) {
			if (n == 6 || n == 9) {
				if (count_arr[6] > count_arr[9]) {
					count_arr[9] += 1;
				} else if (count_arr[6] < count_arr[9]) {
					count_arr[6] += 1;
				} else {
					count_arr[n] += 1;
				}
			} else {
				count_arr[n] += 1;
			}
				
		}
		
		int max = 0;
		
		for(int i = 0 ; i < 10 ; i++) {
			max = Math.max(max, count_arr[i]);
		}
		
		System.out.println(max);
		
	}
		
	}
