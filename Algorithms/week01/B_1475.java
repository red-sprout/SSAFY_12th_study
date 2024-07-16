import java.util.Arrays;
import java.util.Scanner;

public class B_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int [] plastic = new int[10];

        for(int i = 0; i <N.length(); i++){
            int num =Character.getNumericValue(N.charAt(i));

            if (num==6) num=9;
            plastic[num]++;
        }
        plastic[9] = ( plastic[9] / 2) + (plastic[9] % 2);
        Arrays.sort(plastic);

        System.out.println(plastic[9]);
    }
}
