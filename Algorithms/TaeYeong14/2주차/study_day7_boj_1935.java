import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 처리
        int size = Integer.parseInt(br.readLine());
        String data = br.readLine();
        int[] numList = new int[size];
        Stack<Double> stack = new Stack<>();

        // 숫자 입력 처리
        for (int i = 0; i < size; i++) {
            numList[i] = Integer.parseInt(br.readLine());
        }


        // 연산 수행
        for (char d : data.toCharArray()) {
            if (d == '+' || d == '-' || d == '*' || d == '/') {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double result = 0.0;
                switch (d) {
                	case '+':
                		result = num1 + num2;
                		break;
                	case '-':
                		result = num1 - num2;
                		break;
                	case '*':
                		result = num1 * num2;
                		break;
                	case '/':
                		result = num1 / num2;
                		break;
                }
                stack.push(result);
            } else {
                stack.push((double) numList[d - 'A']);
            }
        }

        // 결과 출력
        System.out.printf("%.2f\n", stack.pop());

    }
}
