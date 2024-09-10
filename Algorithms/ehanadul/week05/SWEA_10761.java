package swea;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class SWEA_10761 {
	
	static class Button {
	    char color;
	    int idx;

	    public Button(char color, int idx) {
	        this.color = color;
	        this.idx = idx;
	    }
	}
   
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            Queue<Button> buttons = new LinkedList<>();
            Queue<Button> blues = new LinkedList<>();
            Queue<Button> oranges = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char color = sc.next().charAt(0);
                int idx = sc.nextInt();
                Button button = new Button(color, idx);
                if (color == 'B') {
                    blues.offer(button);
                } else {
                    oranges.offer(button);
                }
                buttons.offer(button);
            }
            int blue = 0;
            int orange = 0;
            int time = 0;
            boolean click = false;
            while (!buttons.isEmpty()) {
                time++;
                click = false;
                if (!blues.isEmpty()) {
                    if (blue < blues.peek().idx) {
                        blue++;
                    } else if (blue > blues.peek().idx) {
                        blue--;
                    } else {
                        if (buttons.peek().color == 'B') {
                            click = true;
                            blues.poll();
                        }
                    }
                }
                if (!oranges.isEmpty()) {
                    if (orange < oranges.peek().idx) {
                        orange++;
                    } else if (orange > oranges.peek().idx) {
                        orange--;
                    } else {
                        if (buttons.peek().color == 'O') {
                            click = true;
                            oranges.poll();
                        }
                    }
                }
                if (click) {
                    buttons.poll();
                }
            }
            System.out.println("#" + tc + " " + (time - 1));
        }
    }
}