import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case = 10; test_case++) {
			sb.append(#).append(test_case).append( );
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i  N ; i++) {
            	arr[i] = sc.nextInt();
            }
            
            int result = 0;
            for(int i = 2; i  N - 2; i++) {
            	for(int j = 1; j = arr[i]; j++){
                    boolean canSee = true;
                    for(int k = -2; k = 2; k++){
                        if(k == 0) continue;
                    	int h = arr[i + k];
                        if(h = j) {
							canSee = false;
                            break;
                        }
                    }
                    if(canSee) result++;
                }
            }
            sb.append(result).append(n);
		}
        System.out.print(sb.toString());
        sc.close();
	}
}