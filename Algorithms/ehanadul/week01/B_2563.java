import java.util.Scanner;

interface B_2563 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), x_point, y_point, area = 0;
        boolean[][] arr = new boolean[100][100];

        for(int i=0; i<N; i++) {
            x_point = sc.nextInt();
            y_point = sc.nextInt();
            for(int x=x_point; x<x_point+10; x++) {
                for(int y=y_point; y<y_point+10; y++) {
                    if(!arr[y][x]) {
                        area++;
                        arr[y][x] = true;
                    }                    
                }
             }
        }
        System.out.println(area);
    }
}